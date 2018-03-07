package com.lantaiyuan.carpool.charge.service;

import com.lantaiyuan.carpool.charge.domain.request.ChargeRequest;

import java.math.BigDecimal;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:36$
 * @description:
 */
public interface IChargeService {
    /**
     * 根据请求参数计算需要的费用
     * @param chargeRequest
     * @return
     */
    BigDecimal charge(ChargeRequest chargeRequest);
}
