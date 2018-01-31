package com.lantaiyuan.carpool.common;

import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/9$ 15:39$
 * @description:
 */
public enum ResultCodeEnum {
    SUCCESS(100),INVALIDATE_PARAM(101),ORDER_INVALIDATE(102),ORDER_CAN_ADD(103),ORDER_CAN_NOT_CANCEL(104);
    @Getter
    private Integer value;

    ResultCodeEnum(Integer value) {
        this.value = value;
    }

}
