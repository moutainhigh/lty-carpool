package com.lantaiyuan.carpool.websocket.service;

import com.lantaiyuan.carpool.websocket.domain.WebSocketRequest;
import com.lantaiyuan.carpool.websocket.domain.WebSocketResponse;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 21:50$
 * @description:
 */
public interface IWebSocketService {
    WebSocketResponse getMatch(WebSocketRequest webSocketRequest);
}
