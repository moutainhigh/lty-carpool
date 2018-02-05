package com.lantaiyuan.carpool.common.service.impl;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.common.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/2/5$ 10:20$
 * @description:
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    public int similarity(Order order0, Order order1) {

        return 99;
    }
}
