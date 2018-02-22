package com.lantaiyuan.carpool.common.constant;

import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/2$ 14:51$
 * @description:
 */
public enum LineStatusEnum {
    BUS_START(101),NO_STATUS(102);
    @Getter
    private Integer value;

    LineStatusEnum(int value) {
        this.value = value;
    }
}
