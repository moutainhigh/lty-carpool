package com.lantaiyuan.carpool.order.service;

import com.lantaiyuan.carpool.order.domain.request.CancelRequest;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:50$
 * @description:
 */
public interface ICancelService {
    /**
     *
     * @param cancelRequest
     * @return
     */
    int cancel(CancelRequest cancelRequest);
}
