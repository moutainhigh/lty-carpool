package com.lantaiyuan.carpool.match.controller;

import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.ResultObject;
import com.lantaiyuan.carpool.match.domain.MatchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
public class MatchController {
    @Autowired
    private IMatchService matchService;

    @MessageMapping(value="/match")
    @SendTo("/topic/track")
    public ResultObject match(MatchRequest matchRequest) throws Exception {
        matchService.getMatch(matchRequest);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),0);
    }
    @SendTo("/topic/track")
    @Scheduled(fixedRate = 1000)
    public ResultObject match() throws Exception {
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),0);
    }
}
