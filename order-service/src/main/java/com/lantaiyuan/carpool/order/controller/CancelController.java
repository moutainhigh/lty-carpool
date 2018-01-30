package com.lantaiyuan.carpool.order.controller;

import com.lantaiyuan.carpool.common.ResultCodeEnum;
import com.lantaiyuan.carpool.common.ResultObject;
import com.lantaiyuan.carpool.order.domain.request.CancelRequest;
import com.lantaiyuan.carpool.order.service.ICancelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 18:00$
 * @description:
 */
@RestController
@Slf4j
public class CancelController {
    @Autowired
    private ICancelService cancelService;
    @RequestMapping(value = "/order/cancel", method = RequestMethod.POST)
    public ResultObject cancel(@RequestBody CancelRequest cancelRequest) {
        if(!cancelRequest.validate()){
            return new ResultObject(ResultCodeEnum.INVALIDATE.getValue());
        }
        int r = cancelService.cancel(cancelRequest);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), r);
        return ret;
    }
}
