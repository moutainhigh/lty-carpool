package com.lantaiyuan.carpool.match.service;

import com.lantaiyuan.carpool.match.domain.MatchRequest;
import com.lantaiyuan.carpool.match.domain.MatchResponse;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 21:50$
 * @description:
 */
public interface IMatchService {
    MatchResponse getMatch(MatchRequest matchRequest);
}
