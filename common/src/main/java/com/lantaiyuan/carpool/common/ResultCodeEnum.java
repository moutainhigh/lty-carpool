package com.lantaiyuan.carpool.common;

import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/9$ 15:39$
 * @description:
 */
public enum ResultCodeEnum {
    SUCCESS(001),INVALIDATE(002);
    @Getter
    private Integer value;

    ResultCodeEnum(Integer value) {
        this.value = value;
    }

}
