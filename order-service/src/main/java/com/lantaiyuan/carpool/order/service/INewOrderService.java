package com.lantaiyuan.carpool.order.service;

import com.lantaiyuan.carpool.common.domain.request.NewOrderRequest;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:50$
 * @description:
 */
public interface INewOrderService {
    /**
     * 添加新订单
     * @param newOrderRequest
     * @return
     */
    int newOrder(NewOrderRequest newOrderRequest);
}
