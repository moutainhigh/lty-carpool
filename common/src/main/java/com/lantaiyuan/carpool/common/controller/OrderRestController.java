package com.lantaiyuan.carpool.common.controller;


import com.lantaiyuan.carpool.common.ResultObject;
import com.lantaiyuan.carpool.common.ResultCodeEnum;
import com.lantaiyuan.carpool.common.common.dao.OrderRepository;
import com.lantaiyuan.carpool.common.common.domain.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 9:52$
 * @description:
 */
@Api(value = "order", description = "订单信息")
@Slf4j
@RestController
public class OrderRestController {
    @Autowired
    private OrderRepository orderRepository;

    @ApiOperation(value="根据订单id，查询订单信息",produces = "application/json")
    @RequestMapping(value = "/api/order/{id}", method = RequestMethod.GET)
    public ResultObject index(@PathVariable("id") Long id) {
        Order order = orderRepository.findOne(id);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), order);
        if(order ==null){
            ret.setMassage("can't find order");
        }
        return ret;
    }
    @ApiOperation(value="新增订单信息",produces = "application/json")
    @RequestMapping(value = "/api/order", method = RequestMethod.POST)
    public ResultObject createOrder(@RequestBody Order orderEntity) {
        Order order = orderRepository.save(orderEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),order);
    }
    @ApiOperation(value="更新订单信息",produces = "application/json")
    @RequestMapping(value = "/api/order", method = RequestMethod.PUT)
    public ResultObject modifyOrder(@RequestBody Order orderEntity) {
        Order order = orderRepository.save(orderEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),order);
    }
    @ApiOperation(value="根据订单id，删除订单信息",produces = "application/json")
    @RequestMapping(value = "/api/order/{id}", method = RequestMethod.DELETE)
    public ResultObject modifyOrder(@PathVariable("id") Long id) {
        orderRepository.delete(id);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),null);
    }
}
