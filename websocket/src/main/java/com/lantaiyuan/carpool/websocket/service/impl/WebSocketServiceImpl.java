package com.lantaiyuan.carpool.websocket.service.impl;

import com.lantaiyuan.carpool.websocket.service.IWebSocketService;
import com.lantaiyuan.carpool.websocket.domain.WebSocketRequest;
import com.lantaiyuan.carpool.websocket.domain.WebSocketResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

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
    private StringRedisTemplate localRedisTemplate;
    @Override
    public WebSocketResponse getMatch(WebSocketRequest webSocketRequest) {
//        localRedisTemplate
        return null;
    }
}
