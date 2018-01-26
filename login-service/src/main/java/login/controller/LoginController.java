package login.controller;

import com.lantaiyuan.carpool.common.ResultObject;
import com.lantaiyuan.carpool.common.constant.ResultCodeEnum;
import login.domain.request.LoginRequest;
import login.domain.response.LoginResponse;
import login.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 9:52$
 * @description:
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @RequestMapping(value = "/login/login", method = RequestMethod.POST)
    public ResultObject login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.getUserStatusOrRecommend(loginRequest);
        ResultObject ret = new ResultObject(ResultCodeEnum.SUCCESS.getValue(), loginResponse);
        return ret;
    }
}
