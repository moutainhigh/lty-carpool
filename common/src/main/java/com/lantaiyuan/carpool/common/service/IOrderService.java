package com.lantaiyuan.carpool.common.service;

import com.lantaiyuan.carpool.common.domain.Order;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 10:19$
 * @description:
 */
public interface IOrderService {
    /**
     * 订单相似度计算，最大pi*100
     * @param order0
     * @param order1
     * @return
     */
     double similarity(Order order0, Order order1);
}
