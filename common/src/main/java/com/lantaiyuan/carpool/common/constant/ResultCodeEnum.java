package com.lantaiyuan.carpool.common.constant;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/9$ 15:39$
 * @description:
 */
public enum ResultCodeEnum {
    SUCCESS(001);
    Integer value;

    ResultCodeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    }
