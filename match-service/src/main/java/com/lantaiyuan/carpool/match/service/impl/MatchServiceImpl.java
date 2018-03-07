package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.common.constant.RedisPoolKey;
import com.lantaiyuan.carpool.common.constant.UserStatusEnum;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;
import com.lantaiyuan.carpool.common.service.IOrderService;
import com.lantaiyuan.carpool.match.service.IMatchService;
import com.robert.vesta.service.intf.IdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;


/**
 * @author qiuwanshan
 */
@Service
@ImportResource("spring/vesta-service-sample.xml")
@Slf4j
public class MatchServiceImpl implements IMatchService {
    final int MIN_ORDER_SIMILAR=80;
    @Autowired
    private IOrderService orderService;
    @Resource(name="redisTemplate")
    private RedisTemplate localRedisTemplate;
    @Autowired
    private IdService idService;

    /**
     * 取消撮合
     * @param cancelRequest
     */
    @Override
    public void matchCancel(CancelRequest cancelRequest) {
        BoundHashOperations<String, Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        BoundHashOperations<String, String, User> userPool = localRedisTemplate.boundHashOps(RedisPoolKey.userPoolKey);
        BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps(RedisPoolKey.tourPoolKey);
        //从缓存中查询用户信息
        User user= userPool.get(cancelRequest.getUserId());
        long lineId=user.getLineId();
        long orderId=user.getOrderId();
        //从线路缓存池中删除订单
        linePool.get(lineId).remove(orderId);
        //如果线路已空则删除线路信息
        if(linePool.get(lineId).size()==0){
            linePool.delete(lineId);
        }
        //从订单池中删除订单
        orderPool.delete(orderId);
        //行程池删除行程
        tourPool.geoRemove(""+orderId+"-"+lineId);
        //用户池删除用户
        userPool.delete(user.getUserId());
    }

    /**
     * 撮合订单
     * @param order
     */
    @Override
    public void matchOrder(Order order) {
        //获取线路缓存池
        BoundHashOperations<String, String, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        BoundHashOperations<String, String, User> userPool = localRedisTemplate.boundHashOps(RedisPoolKey.userPoolKey);
        BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps(RedisPoolKey.tourPoolKey);
        //获取订单起始点
        Point point = new Point(order.getStartLongitude(), order.getStartLatitude());
        Long orderId=order.getOrderId();
        Long lineId;
        //新订单，没有线路id
        if (0 == order.getLineId()) {
            lineId = realMatch(order);
            //没有合适线路，为该订单生成新线路
            if (lineId == 0) {
                //生成线路id
                lineId = idService.genId();
            }
            //为订单设置线路id
            order.setLineId(lineId);
        }
        //有线路id，说明是加入某条线路
        else {
            //获取线路id
            lineId = order.getLineId();
        }
        //保存该订单到定单缓存
        orderPool.put(order.getOrderId(), order);
        //为行程指定id并缓存到行程池
        tourPool.geoAdd(point, ""+orderId+"-"+lineId);
        //将订单id加入线路缓存
        linePool.get(lineId).add(orderId);
        //缓存用户信息
        User user= new User();
        user.setUserId(order.getUserId());
        user.setLineId(lineId);
        user.setOrderId(orderId);
        user.setUserStatus(UserStatusEnum.MATCH.getValue());
        userPool.put(user.getUserId(),user);
    }

    /**
     * 实际撮合合适的线路
     * @param order
     * @return 线路id
     */
    private long realMatch(Order order) {
        BoundHashOperations<String, Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        BoundHashOperations<String, String, User> userPool = localRedisTemplate.boundHashOps(RedisPoolKey.userPoolKey);
        BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps(RedisPoolKey.tourPoolKey);
        double maxSimilarity=0;
        long similarOrderId=0L;
        //获取订单起点
        Point point = new Point(order.getStartLongitude(), order.getStartLatitude());
        //指定周边范围
        Circle within = new Circle(point,new Distance(100));
        //获取附近行程
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = tourPool.geoRadius(within);
        Iterator<GeoResult<RedisGeoCommands.GeoLocation<String>>> it = results.iterator();
        /**
         * 求周边最大相似度订单
         */
        while (it.hasNext()){
            Long orderId=Long.parseLong(it.next().getContent().getName().split("-")[0]);
            double similarity=orderService.similarity(order,orderPool.get(orderId));
            if(similarity>maxSimilarity){
                maxSimilarity=similarity;
                similarOrderId=orderId;
            }
        }
        //有合适的相似订单
        if(similarOrderId!=0&&maxSimilarity>MIN_ORDER_SIMILAR){
            return orderPool.get(similarOrderId).getLineId();
        }
        return 0L;
    }
}
