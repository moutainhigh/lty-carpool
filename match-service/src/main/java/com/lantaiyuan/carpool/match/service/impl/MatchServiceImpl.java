package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.match.domain.MatchRequest;
import com.lantaiyuan.carpool.match.domain.MatchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 21:50$
 * @description:
 */
@Service
@Slf4j
public class MatchServiceImpl implements IMatchService {
    @Override
    public MatchResponse getMatch(MatchRequest matchRequest) {
        return null;
    }
}
