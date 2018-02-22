package com.lantaiyuan.carpool.common.controller;


import com.lantaiyuan.carpool.common.constant.ResultObject;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.dao.LineRepository;
import com.lantaiyuan.carpool.common.domain.Line;
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
@Api(value = "line", description = "线路信息")
@Slf4j
@RestController
public class LineRestController {
    @Autowired
    private LineRepository lineRepository;

    @ApiOperation(value="根据线路id，查询线路信息",produces = "application/json")
    @RequestMapping(value = "/api/line/{id}", method = RequestMethod.GET)
    public ResultObject index(@PathVariable("id") long id) {
        Line line = lineRepository.findOne(id);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), line);
        if(line ==null){
            ret.setMassage("can't find line");
        }
        return ret;
    }
    @ApiOperation(value="新增线路信息",produces = "application/json")
    @RequestMapping(value = "/api/line", method = RequestMethod.POST)
    public ResultObject createLine(@RequestBody Line lineEntity) {
        Line line = lineRepository.save(lineEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),line);
    }
    @ApiOperation(value="更新线路信息",produces = "application/json")
    @RequestMapping(value = "/api/line", method = RequestMethod.PUT)
    public ResultObject modifyLine(@RequestBody Line lineEntity) {
        Line line = lineRepository.save(lineEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),line);
    }
    @ApiOperation(value="根据线路id，删除线路信息",produces = "application/json")
    @RequestMapping(value = "/api/line/{id}", method = RequestMethod.DELETE)
    public ResultObject modifyLine(@PathVariable("id") long id) {
        lineRepository.delete(id);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue());
    }
}
