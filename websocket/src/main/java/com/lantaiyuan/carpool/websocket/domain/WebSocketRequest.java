package com.lantaiyuan.carpool.websocket.domain;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/16$ 10:05$
 * @description:用户websocket请求
 */
@Data
public class WebSocketRequest implements Validate,Serializable {
    /**
     * 用户id
     */
    String userId;
    /**
     * 事件时间
     */
    Long eventTime;

    @Override
    public boolean validate() {
        return true;
    }
}
