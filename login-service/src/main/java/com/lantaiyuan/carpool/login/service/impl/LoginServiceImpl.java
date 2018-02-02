package com.lantaiyuan.carpool.login.service.impl;

import com.lantaiyuan.carpool.common.RedisPoolKey;
import com.lantaiyuan.carpool.common.UserStatusEnum;
import com.lantaiyuan.carpool.common.dao.UserRepository;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.request.LoginRequest;
import com.lantaiyuan.carpool.common.domain.response.Line2User;
import com.lantaiyuan.carpool.common.domain.response.LoginResponse;
import com.lantaiyuan.carpool.common.domain.response.Tour2User;
import com.lantaiyuan.carpool.login.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
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
 * @date: 2018/1/11$ 9:42$
 * @description:
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {
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
        Line2User line=null;
        if(user.getUserStatus().equals( UserStatusEnum.NO_STATUS.getValue())){
             line = recommend(user);
        }else if(user.getUserStatus().equals( UserStatusEnum.MATCH_STATUS.getValue())){
             line = getLine(user);
        }
        loginResponse.setLine(line);
        return loginResponse;
    }

    /**
     * 推荐线路
     * @param user
     * @return
     */
    Line2User recommend(User user){
        Line2User line = new Line2User();
        return line;
    }

    /**
     * 获取用户当前所在处线路状况
     * @param user
     * @return
     */
    Line2User getLine(User user){
        Line2User line = new Line2User();
        Order order;
        List<Tour2User> tour2UserList=new ArrayList<>();
        Tour2User tour2User;
        Set<Long> orderIds = linePool.get(user.getLineId());
        for (Long orderId:
                orderIds) {
            order=orderPool.get(orderId);
            tour2User=new Tour2User(order.getStartLongitude(),order.getStartLatitude(),order.getEndLongitude(),order.getEndLatitude());
            tour2UserList.add(tour2User);
        }
        line.setLineId(user.getLineId());
        line.setTours(tour2UserList);
        return line;
    }
}
