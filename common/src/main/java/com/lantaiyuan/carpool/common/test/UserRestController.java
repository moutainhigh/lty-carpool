package com.lantaiyuan.carpool.common.test;


import com.lantaiyuan.carpool.common.dao.UserRepository;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import com.lantaiyuan.carpool.common.ResultObject;
import com.lantaiyuan.carpool.common.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 9:52$
 * @description:
 */
@Api(value = "user", description = "用户信息")
@RestController
public class UserRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value="根据用户id，查询用户信息",produces = "application/json")
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public ResultObject index(@PathVariable("id") String id) {
        User user = userRepository.findOne(id);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), user);
        if(user ==null){
            ret.setMassage("can't find user");
        }
        return ret;
    }
    @ApiOperation(value="新增用户信息",produces = "application/json")
    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public ResultObject createUser(@RequestBody User userEntity) {
        User user = userRepository.save(userEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),user);
    }
    @ApiOperation(value="更新用户信息",produces = "application/json")
    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public ResultObject modifyUser(@RequestBody User userEntity) {
        User user = userRepository.save(userEntity);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),user);
    }
    @ApiOperation(value="根据用户id，删除用户信息",produces = "application/json")
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public ResultObject modifyUser(@PathVariable("id") String id) {
        userRepository.delete(id);
        return new ResultObject(ResultCodeEnum.SUCCESS.getValue(),null);
    }
}
