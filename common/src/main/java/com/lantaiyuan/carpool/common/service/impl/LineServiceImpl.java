package com.lantaiyuan.carpool.common.service.impl;

import com.lantaiyuan.carpool.common.constant.LineStatusEnum;
import com.lantaiyuan.carpool.common.constant.RedisPoolKey;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.response.Line4User;
import com.lantaiyuan.carpool.common.domain.response.Tour4User;
import com.lantaiyuan.carpool.common.service.ILineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 16:45$
 * @description:线路相关服务
 */
@Service
public class LineServiceImpl implements ILineService {
    /**
     * 最小乘客要求
     */
    final static Integer MIN_PERSON = 7;
    @Resource(name="redisTemplate")
    private RedisTemplate localRedisTemplate;

    /**
     * 根据线路id求线路包含的信息，用于返回给客户端
     * @param lineId
     * @return 返回给用户的线路信息，该线路信息包含该线路的所有行程信息
     */
    @Override
    public Line4User lineId2Line4User(long lineId) {
        //获取线路缓存池
        BoundHashOperations<String, String, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        //获取订单缓存池
        BoundHashOperations<String, String, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        Line4User line4User = new Line4User();
        Order order;
        List<Tour4User> tour4UserList = new ArrayList<>();
        Tour4User tour4User;
        //根据线路id，查询该线路所包含的所有订单id
        Set<Long> orderIds = linePool.get(String.valueOf(lineId));
        //线路中不包含任何订单，如果不允许取消订单，则不应出现此种情况
        if(orderIds==null){
            return null;
        }
        /**
         * 提取所有订单的行程信息，将行程信息放进链表
         */
        for (Long orderId :
                orderIds) {
            order = orderPool.get(String.valueOf(orderId));
            tour4User = new Tour4User(order.getStartLongitude(), order.getStartLatitude(), order.getEndLongitude(), order.getEndLatitude());
            tour4UserList.add(tour4User);
        }
        //为返回设置线路id
        line4User.setLineId(lineId);
        //为返回设置行程信息
        line4User.setTours(tour4UserList);
        //如果线路人数到达定值则存在车辆信息
        if (linePool.get(String.valueOf(lineId)).size() > MIN_PERSON) {
            line4User.setLineStatus(LineStatusEnum.BUS_START.getValue());
            //TODO 设置bus信息
        }
        return line4User;
    }
}
