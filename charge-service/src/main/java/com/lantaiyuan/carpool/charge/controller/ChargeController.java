package com.lantaiyuan.carpool.charge.controller;

import com.lantaiyuan.carpool.charge.domain.request.ChargeRequest;
import com.lantaiyuan.carpool.charge.service.IChargeService;
import com.lantaiyuan.carpool.common.ResultCodeEnum;
import com.lantaiyuan.carpool.common.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:38$
 * @description:
 */
@RestController
@Slf4j
public class ChargeController {
    @Autowired
    private IChargeService chargeService;
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public ResultObject charge(@RequestBody ChargeRequest chargeRequest) {
        if(!chargeRequest.validate()){
            return new ResultObject(ResultCodeEnum.INVALIDATE.getValue(), 0);
        }
        double r = chargeService.charge(chargeRequest);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), r);
        return ret;
    }
}
