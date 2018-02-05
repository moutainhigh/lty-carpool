package com.lantaiyuan.carpool.login.service.impl;

import com.lantaiyuan.carpool.common.constant.LineStatusEnum;
import com.lantaiyuan.carpool.common.constant.RedisPoolKey;
import com.lantaiyuan.carpool.common.constant.UserStatusEnum;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.request.LoginRequest;
import com.lantaiyuan.carpool.common.domain.response.Line4User;
import com.lantaiyuan.carpool.common.domain.response.LoginResponse;
import com.lantaiyuan.carpool.common.domain.response.Tour4User;
import com.lantaiyuan.carpool.login.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:42$
 * @description:
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {
    final static Double MIN_DISTANCE=2000d;
    final static Integer MIN_PERSON=7;
    @Autowired
    private StringRedisTemplate localRedisTemplate;
    private BoundHashOperations<String,Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
    private BoundHashOperations<String, Long, Order> orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
    private BoundHashOperations<String, String, User> userPool = localRedisTemplate.boundHashOps(RedisPoolKey.userPoolKey);
    private BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps(RedisPoolKey.tourPoolKey);
    @Override
    public LoginResponse getUserStatusOrRecommend(LoginRequest loginRequest) {
        User user=userPool.get(loginRequest.getUserId());
        LoginResponse loginResponse =new LoginResponse();
        List<Line4User> lines=null;
        if(user.getUserStatus().equals( UserStatusEnum.NO_STATUS.getValue())){
             lines = recommend(loginRequest);
        }else if(user.getUserStatus().equals( UserStatusEnum.MATCH_STATUS.getValue())){
             lines = getLine(user);
        }
        loginResponse.setLines(lines);
        return loginResponse;
    }

    /**
     * 推荐线路
     * @param loginRequest
     * @return
     */
    List<Line4User> recommend(LoginRequest loginRequest){
        Point point = new Point(loginRequest.getLongitude(), loginRequest.getLatitude());
        Circle within = new Circle(point,new Distance(MIN_DISTANCE));
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = tourPool.geoRadius(within);
        Iterator<GeoResult<RedisGeoCommands.GeoLocation<String>>> it = results.iterator();
        List<Line4User> lines = new ArrayList<>();
        Line4User line4User;
        while (it.hasNext()){
            Long lineId=Long.parseLong(it.next().getContent().getName().split("-")[1]);
            line4User=lineId2Line4User(lineId);
            lines.add(line4User);
        }
        return lines;
    }

    /**
     * 获取用户当前所在处线路状况
     * @param user
     * @return
     */
    List<Line4User> getLine(User user){
        List<Line4User> lines = new ArrayList<>();
        lines.add(lineId2Line4User(user.getLineId()));
        return lines;
    }
    Line4User lineId2Line4User(Long lineId){
        Line4User line4User = new Line4User();
        Order order;
        List<Tour4User> tour4UserList =new ArrayList<>();
        Tour4User tour4User;
        Set<Long> orderIds = linePool.get(lineId);
        for (Long orderId:
                orderIds) {
            order=orderPool.get(orderId);
            tour4User =new Tour4User(order.getStartLongitude(),order.getStartLatitude(),order.getEndLongitude(),order.getEndLatitude());
            tour4UserList.add(tour4User);
        }
        line4User.setLineId(lineId);
        line4User.setTours(tour4UserList);
        //如果线路人数到达定值则存在车辆信息
        if(linePool.get(lineId).size()>MIN_PERSON){
            line4User.setLineStatus(LineStatusEnum.BUS_START.getValue());
            //TODO 设置bus信息
        }
        return line4User;
    }
}
