package com.lantaiyuan.carpool.order.service.impl;

import com.lantaiyuan.carpool.order.domain.request.NewOrderRequest;
import com.lantaiyuan.carpool.order.service.INewOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:54$
 * @description:
 */
@Service
@Slf4j
public class NewOrderServiceImpl implements INewOrderService {

    @Override
    public int newOrder(NewOrderRequest newOrderRequest) {

        return 0;
    }
}
