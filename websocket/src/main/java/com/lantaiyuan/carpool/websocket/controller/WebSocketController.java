package com.lantaiyuan.carpool.websocket.controller;

import com.lantaiyuan.carpool.websocket.domain.WebSocketResponse;
import com.lantaiyuan.carpool.websocket.service.IWebSocketService;
import com.lantaiyuan.carpool.common.ResultCodeEnum;
import com.lantaiyuan.carpool.common.ResultObject;
import com.lantaiyuan.carpool.websocket.domain.WebSocketRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/16$ 9:56$
 * @description:
 */
@Controller
@EnableScheduling
@Slf4j
public class WebSocketController {
    private WebSocketRequest webSocketRequest;
    @Autowired
    private IWebSocketService webSocketService;
    @MessageMapping(value="/match")
    @SendTo("/topic/track")
    public ResultObject match(WebSocketRequest webSocketRequest) throws Exception {
        this.webSocketRequest = webSocketRequest;
        if(!webSocketRequest.validate()){
            return new ResultObject(ResultCodeEnum.INVALIDATE.getValue());
        }
        WebSocketResponse response =webSocketService.getMatch(webSocketRequest);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),response);
    }

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/track")
    public ResultObject  track() {
        WebSocketResponse response =webSocketService.getMatch(webSocketRequest);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),response);

    }
}
