package com.lantaiyuan.carpool.websocket.controller;

import com.lantaiyuan.carpool.websocket.domain.WebSocketResponse;
import com.lantaiyuan.carpool.websocket.service.IWebSocketService;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.constant.ResultObject;
import com.lantaiyuan.carpool.websocket.domain.WebSocketRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
//        this.webSocketRequest = webSocketRequest;
//        if(!webSocketRequest.validate()){
//        ResultObject rs = new ResultObject(ResultCodeEnum.INVALIDATE_PARAM.getValue());
//        rs.setMassage("请检查参数");
//        return rs;
//        }
//        WebSocketResponse response =webSocketService.getMatch(webSocketRequest);
//        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),response);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),"test");
    }


    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Autowired
    private SimpMessagingTemplate broker;
    @Scheduled(fixedRate = 1000)
    public void run() {
//        WebSocketResponse response =webSocketService.getMatch(webSocketRequest);
//        broker.convertAndSend("/topic/track", new ResultObject(ResultCodeEnum.SUCCESS.getValue(),response));
        String time = LocalTime.now().format(TIME_FORMAT);
        log.info("Time broadcast: {}", time);
        broker.convertAndSend("/topic/track", new ResultObject(ResultCodeEnum.SUCCESS.getValue(),time));
    }
}
