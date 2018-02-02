package com.lantaiyuan.carpool.common.controller;


import com.lantaiyuan.carpool.common.constant.ResultObject;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.BusRepository;
import com.lantaiyuan.carpool.common.domain.Bus;
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
@Api(value = "bus", description = "公交信息")
@Slf4j
@RestController
public class BusRestController {
    @Autowired
    private BusRepository busRepository;

    @ApiOperation(value="根据公交id，查询公交信息",produces = "application/json")
    @RequestMapping(value = "/api/bus/{id}", method = RequestMethod.GET)
    public ResultObject index(@PathVariable("id") String id) {
        Bus bus = busRepository.findOne(id);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), bus);
        if(bus ==null){
            ret.setMassage("can't find bus");
        }
        return ret;
    }
    @ApiOperation(value="新增公交信息",produces = "application/json")
    @RequestMapping(value = "/api/bus", method = RequestMethod.POST)
    public ResultObject createBus(@RequestBody Bus busEntity) {
        Bus bus = busRepository.save(busEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),bus);
    }
    @ApiOperation(value="更新公交信息",produces = "application/json")
    @RequestMapping(value = "/api/bus", method = RequestMethod.PUT)
    public ResultObject modifyBus(@RequestBody Bus busEntity) {
        Bus bus = busRepository.save(busEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),bus);
    }
    @ApiOperation(value="根据公交id，删除公交信息",produces = "application/json")
    @RequestMapping(value = "/api/bus/{id}", method = RequestMethod.DELETE)
    public ResultObject modifyBus(@PathVariable("id") String id) {
        busRepository.delete(id);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue());
    }
}
