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
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 16:45$
 * @description:
 */
@Service
public class LineServiceImpl implements ILineService {
    final static Integer MIN_PERSON = 7;
    @Autowired
    private StringRedisTemplate localRedisTemplate;

    @Override
    public Line4User lineId2Line4User(long lineId) {
        BoundHashOperations<String, Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        BoundHashOperations<String, String, User> userPool = localRedisTemplate.boundHashOps(RedisPoolKey.userPoolKey);
        BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps(RedisPoolKey.tourPoolKey);
        Line4User line4User = new Line4User();
        Order order;
        List<Tour4User> tour4UserList = new ArrayList<>();
        Tour4User tour4User;
        Set<Long> orderIds = linePool.get(lineId);
        for (Long orderId :
                orderIds) {
            order = orderPool.get(orderId);
            tour4User = new Tour4User(order.getStartLongitude(), order.getStartLatitude(), order.getEndLongitude(), order.getEndLatitude());
            tour4UserList.add(tour4User);
        }
        line4User.setLineId(lineId);
        line4User.setTours(tour4UserList);
        //如果线路人数到达定值则存在车辆信息
        if (linePool.get(lineId).size() > MIN_PERSON) {
            line4User.setLineStatus(LineStatusEnum.BUS_START.getValue());
            //TODO 设置bus信息
        }
        return line4User;
    }
}
