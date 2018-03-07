package com.lantaiyuan.carpool.common.constant;

import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 10:01$
 * @description:用户状态
 */
public enum UserStatusEnum {
    /**
     * NO_STATUS 空状态
     * MATCH 撮合中状态
     * ON_BUS 已上车
     * OFF_BUS 已下车
     */
    NO_STATUS(201),MATCH(202),ON_BUS(203),OFF_BUS(204);
    @Getter
    private Integer value;

    UserStatusEnum(int value) {
        this.value = value;
    }
}
