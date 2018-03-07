package com.lantaiyuan.carpool.common.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/30$ 16:09$
 * @description: 订单状态
 */
public enum OrderStatusEnum {
    /**
     * MATCH 拼车中
     * CANCEL 取消订单
     * BUS_START 拼车成功，已发车
     * OFF_BUS 已下车
     */
    MATCH(301),CANCEL(302),BUS_START(303),OFF_BUS(304);
    @Getter
    private Integer value;

    OrderStatusEnum(int value) {
        this.value = value;
    }
}
