package com.lantaiyuan.carpool.charge.controller;

import com.lantaiyuan.carpool.charge.domain.request.ChargeRequest;
import com.lantaiyuan.carpool.charge.service.IChargeService;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.constant.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
        //检验客户端传来的参数
        if(!chargeRequest.validate()){
            ResultObject rs = new ResultObject(ResultCodeEnum.INVALIDATE_PARAM.getValue());
            rs.setMassage("请检查参数");
            return rs;
        }
        //根据行程请求计算费用
        BigDecimal r = chargeService.charge(chargeRequest);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), r);
        return ret;
    }
}
