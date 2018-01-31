package com.lantaiyuan.carpool.match.service.impl;

import com.lantaiyuan.carpool.common.domain.Order;
import com.lantaiyuan.carpool.match.service.IMatchService;
import com.lantaiyuan.carpool.order.domain.request.CancelRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/**
 * @author qiuwanshan
 */
@Service
@Slf4j
public class MatchServiceImpl implements IMatchService {
    @Autowired
    private StringRedisTemplate localRedisTemplate;
    @Override
    public void matchCancel(CancelRequest cancelRequest) {

    }

    @Override
    public void matchOrder(Order order) {
        if(0==order.getLineId()){

        }else{

        }
    }
}
