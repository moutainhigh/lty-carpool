package com.lantaiyuan.carpool.order.service.impl;

import com.lantaiyuan.carpool.order.domain.request.CancelRequest;
import com.lantaiyuan.carpool.order.service.ICancelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:53$
 * @description:
 */
@Service
@Slf4j
public class CancelServiceImpl implements ICancelService {

    @Override
    public int cancel(CancelRequest cancelRequest) {
        //TODO 返费
        return 0;
    }
}
