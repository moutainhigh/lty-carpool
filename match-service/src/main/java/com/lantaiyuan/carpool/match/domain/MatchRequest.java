package com.lantaiyuan.carpool.match.domain;

import com.lantaiyuan.carpool.common.Validate;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/16$ 10:05$
 * @description:
 */
public class MatchRequest implements Validate,Serializable {
    String userId;
    long eventTime;

    @Override
    public Boolean validate() {
        return null;
    }
}
