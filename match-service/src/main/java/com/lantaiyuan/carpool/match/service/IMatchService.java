package com.lantaiyuan.carpool.match.service;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.domain.request.CancelRequest;

/**
 * 撮合服务
 * @author qiuwanshan
 */
public interface IMatchService {
    /**
     * 撮合
     * @param cancelRequest
     */
    void matchCancel(CancelRequest cancelRequest);

    /**
     *
     * @param order
     */
    void matchOrder(Order order);
}
