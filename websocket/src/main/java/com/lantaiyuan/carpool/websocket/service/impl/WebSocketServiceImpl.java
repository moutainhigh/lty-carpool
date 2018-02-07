package com.lantaiyuan.carpool.websocket.service.impl;

import com.lantaiyuan.carpool.common.constant.RedisPoolKey;
import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.common.domain.response.Line4User;
import com.lantaiyuan.carpool.common.service.ILineService;
import com.lantaiyuan.carpool.websocket.service.IWebSocketService;
import com.lantaiyuan.carpool.websocket.domain.WebSocketRequest;
import com.lantaiyuan.carpool.websocket.domain.WebSocketResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 21:50$
 * @description:
 */
@Service
@Slf4j
public class WebSocketServiceImpl implements IWebSocketService {
    @Autowired
    private ILineService lineService;
    @Autowired
    private StringRedisTemplate localRedisTemplate;
    @Override
    public WebSocketResponse getMatch(WebSocketRequest webSocketRequest) {
        BoundHashOperations<String, Long, Set<Long>> linePool = localRedisTemplate.boundHashOps(RedisPoolKey.linePoolKey);
        BoundHashOperations<String, Long, Order>   orderPool = localRedisTemplate.boundHashOps(RedisPoolKey.orderPoolKey);
        BoundHashOperations<String, String, User> userPool = localRedisTemplate.boundHashOps(RedisPoolKey.userPoolKey);
        BoundGeoOperations<String, String> tourPool = localRedisTemplate.boundGeoOps(RedisPoolKey.tourPoolKey);
        User user= userPool.get(webSocketRequest.getUserId());
        Line4User line4User =lineService.lineId2Line4User(user.getLineId());
        return new WebSocketResponse(user.getUserStatus(),line4User);
    }
}
