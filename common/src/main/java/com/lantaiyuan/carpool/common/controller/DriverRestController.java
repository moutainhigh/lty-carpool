package com.lantaiyuan.carpool.common.controller;


import com.lantaiyuan.carpool.common.constant.ResultObject;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.DriverRepository;
import com.lantaiyuan.carpool.common.domain.Driver;
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
@Api(value = "driver", description = "司机信息")
@Slf4j
@RestController
public class DriverRestController {
    @Autowired
    private DriverRepository driverRepository;

    @ApiOperation(value="根据司机id，查询司机信息",produces = "application/json")
    @RequestMapping(value = "/api/driver/{id}", method = RequestMethod.GET)
    public ResultObject index(@PathVariable("id") String id) {
        Driver driver = driverRepository.findOne(id);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), driver);
        if(driver ==null){
            ret.setMassage("can't find driver");
        }
        return ret;
    }
    @ApiOperation(value="新增司机信息",produces = "application/json")
    @RequestMapping(value = "/api/driver", method = RequestMethod.POST)
    public ResultObject createDriver(@RequestBody Driver driverEntity) {
        Driver driver = driverRepository.save(driverEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),driver);
    }
    @ApiOperation(value="更新司机信息",produces = "application/json")
    @RequestMapping(value = "/api/driver", method = RequestMethod.PUT)
    public ResultObject modifyDriver(@RequestBody Driver driverEntity) {
        Driver driver = driverRepository.save(driverEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),driver);
    }
    @ApiOperation(value="根据司机id，删除司机信息",produces = "application/json")
    @RequestMapping(value = "/api/driver/{id}", method = RequestMethod.DELETE)
    public ResultObject modifyDriver(@PathVariable("id") String id) {
        driverRepository.delete(id);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue());
    }
}
