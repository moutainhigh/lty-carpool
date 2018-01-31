package com.lantaiyuan.carpool.charge.service.impl;

import com.lantaiyuan.carpool.charge.domain.request.ChargeRequest;
import com.lantaiyuan.carpool.charge.service.IChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:36$
 * @description:计费服务实现
 */
@Service
@Slf4j
public class ChargeServiceImpl implements IChargeService {
    /**
     * 根据请求参数计算需要的费用
     * @param chargeRequest
     * @return
     */
    @Override
    public Double charge(ChargeRequest chargeRequest) {
        return 0d;
    }
}
