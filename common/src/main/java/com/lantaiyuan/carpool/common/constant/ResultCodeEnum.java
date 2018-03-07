package com.lantaiyuan.carpool.common.constant;

import lombok.Getter;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/9$ 15:39$
 * @description:返回客户端返回码
 */
public enum ResultCodeEnum {
    /**
     * SUCCESS 请求成功
     * INVALIDATE_PARAM 请求请求参数无效
     * ORDER_INVALIDATE 订单请求时间无效
     * ORDER_CAN_ADD 订单可以被加入
     * ORDER_CAN_NOT_CANCEL 订单不能取消
     */
    SUCCESS(100),INVALIDATE_PARAM(101),ORDER_INVALIDATE(102),ORDER_CAN_ADD(103),ORDER_CAN_NOT_CANCEL(104);
    @Getter
    private Integer value;

    ResultCodeEnum(int value) {
        this.value = value;
    }

}
