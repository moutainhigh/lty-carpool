package com.lantaiyuan.carpool.websocket.domain;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/16$ 10:05$
 * @description:
 */
@Data
public class WebSocketRequest implements Validate,Serializable {
    String userId;
    long eventTime;

    @Override
    public Boolean validate() {
        return true;
    }
}
