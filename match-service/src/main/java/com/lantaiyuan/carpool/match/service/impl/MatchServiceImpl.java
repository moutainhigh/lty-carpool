package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.common.domain.Line;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;
import com.lantaiyuan.carpool.match.service.IMatchService;
import com.robert.vesta.service.intf.IdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author qiuwanshan
 */
@Service
@ImportResource("spring/vesta-service-sample.xml")
@Slf4j
public class MatchServiceImpl implements IMatchService {
    @Autowired
    private StringRedisTemplate localRedisTemplate;
    @Autowired
    private IdService idService;
    BoundHashOperations<String,Long, List<Long>> linePool = localRedisTemplate.boundHashOps("car_pool_line");
    private BoundHashOperations<String, Long, Order> orderPool = localRedisTemplate.boundHashOps("car_pool_order");
    private BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps("car_pool_tour");

    @Override
    public void matchCancel(CancelRequest cancelRequest) {

    }

    @Override
    public void matchOrder(Order order) {
        //新订单，没有线路id
        if (0 == order.getLineId()) {
            //保存该订单到缓存
            orderPool.put(order.getOrderId(), order);
            Line line = realMatch(order);
            Long lineId = 0L;
            //有合适线路
            if (line != null) {
                lineId = line.getLineId();
                //将订单id添加到线路
                linePool.get(lineId).add(order.getOrderId());
            }
            //没有合适线路
            else {
                //生成线路id
                lineId = idService.genId();
                ArrayList<Long> orderList= new ArrayList<Long>();
                orderList.add(order.getOrderId());
                linePool.put(lineId,orderList);
            }
            //缓存行程
            saveTour(order,lineId);
        }
        //有线路id，说明是加入某条线路
        else {
            //如果能加入
            if(canAdd(order)){
                //保存该订单到缓存
                orderPool.put(order.getOrderId(), order);
                //将订单id添加到线路缓存
                Long lineId = order.getLineId();
                linePool.get(order.getLineId()).add(order.getOrderId());
                //缓存行程
                saveTour(order,lineId);
            }

        }
    }

    /**
     * 撮合合适的线路
     * @param order
     * @return
     */
    private Line realMatch(Order order) {
        //获取附近行程
        Point point = new Point(order.getStartLongitude(), order.getStartLatitude());
        Circle within = new Circle(point,new Distance(100));
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = tourPool.geoRadius(within);
        Iterator<GeoResult<RedisGeoCommands.GeoLocation<String>>> it = results.iterator();
        return new Line();
    }

    /**
     * 判断订单能否合适加入
     *
     * @param order
     * @return
     */
    private boolean canAdd(Order order) {
        return true;
    }

    /**
     * 缓存行程信息
     * @param order
     * @param lineId
     */
    private void saveTour(Order order,Long lineId){
        Point point = new Point(order.getStartLongitude(), order.getStartLatitude());
        tourPool.geoAdd(point, String.valueOf(lineId));
    }
}
