package com.lantaiyuan.carpool.charge.service.impl;

import com.lantaiyuan.carpool.charge.domain.request.ChargeRequest;
import com.lantaiyuan.carpool.charge.service.IChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:36$
 * @description:
 */
@Service
@Slf4j
public class ChargeServiceImpl implements IChargeService {
    @Override
    public Double charge(ChargeRequest chargeRequest) {
        return 0d;
    }
}
