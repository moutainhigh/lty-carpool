package com.lantaiyuan.carpool.common.constant;

import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/2$ 14:51$
 * @description:线路状态
 */
public enum LineStatusEnum {
    /**
     * MATCH 拼车中，还未满足发车条件
     * BUS_START 车辆已发车
     * ALL_USER_OFF 所有用户已下车
     */
    MATCH(401),BUS_START(402),ALL_USER_OFF(403);
    @Getter
    private Integer value;

    LineStatusEnum(int value) {
        this.value = value;
    }
}
