package com.lantaiyuan.carpool.match.service;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;

/**
 * 撮合服务
 * @author qiuwanshan
 */
public interface IMatchService {
    /**
     * 取消撮合
     * @param cancelRequest
     */
    void matchCancel(CancelRequest cancelRequest);

    /**
     *撮合订单
     * @param order
     */
    void matchOrder(Order order);
}
