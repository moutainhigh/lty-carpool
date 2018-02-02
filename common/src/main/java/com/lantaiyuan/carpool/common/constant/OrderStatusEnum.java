package com.lantaiyuan.carpool.common.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/30$ 16:09$
 * @description:
 */
public enum OrderStatusEnum {
    MATCH(101),CANCEL(102); 
    @Getter
    private Integer value;

    OrderStatusEnum(Integer value) {
        this.value = value;
    }
}
