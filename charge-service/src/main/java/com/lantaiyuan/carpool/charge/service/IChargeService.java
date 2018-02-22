package com.lantaiyuan.carpool.charge.service;

import com.lantaiyuan.carpool.charge.domain.request.ChargeRequest;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:36$
 * @description:
 */
public interface IChargeService {
    /**
     * 计费
     * @param chargeRequest
     * @return
     */
    double charge(ChargeRequest chargeRequest);
}
