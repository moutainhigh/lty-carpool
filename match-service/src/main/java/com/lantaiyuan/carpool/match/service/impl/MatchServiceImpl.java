package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.common.domain.Line;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;
import com.lantaiyuan.carpool.match.service.IMatchService;
import com.robert.vesta.service.intf.IdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;


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
    BoundListOperations<String,String> linePool = localRedisTemplate.boundListOps("car_pool_line");
    private BoundHashOperations<String, Object, Object> orderPool = localRedisTemplate.boundHashOps("car_pool_order");
    private BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps("car_pool_tour");

    @Override
    public void matchCancel(CancelRequest cancelRequest) {

    }

    @Override
    public void matchOrder(Order order) {
        //新订单，没有线路id
        if (0 == order.getLineId()) {
            //保存该订单与该订单包含的行程
            orderPool.put(order.getOrderId(), order);
            Line line = getLine(order);
            Long lineId = 0L;
            //有合适线路
            if (line != null) {
                lineId = line.getLineId();
                //将行程添加到线路
                linePool.leftPush("");
            }
            //没有合适线路
            else {
                //生成线路id
                lineId = idService.genId();
            }
            Point point = new Point(order.getStartLongitude(), order.getStartLatitude());
            tourPool.geoAdd(point, String.valueOf(lineId));
        }
        //有线路id，说明是加入某条线路
        else {

        }
    }

    private Line getLine(Order order) {
        return new Line();
    }
}
