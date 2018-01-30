package com.lantaiyuan.carpool.login.service.impl;

import com.lantaiyuan.carpool.common.UserStatusEnum;
import com.lantaiyuan.carpool.common.domain.Line;
import com.lantaiyuan.carpool.common.domain.User;
import com.lantaiyuan.carpool.login.domain.request.LoginRequest;
import com.lantaiyuan.carpool.login.domain.response.Line2User;
import com.lantaiyuan.carpool.login.domain.response.LoginResponse;
import com.lantaiyuan.carpool.login.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:42$
 * @description:
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Override
    public LoginResponse getUserStatusOrRecommend(LoginRequest loginRequest) {
        User user=getUser(loginRequest);
        LoginResponse loginResponse =new LoginResponse();
        if(user.getStatus().equals( UserStatusEnum.NO_STATUS.getValue())){
            List<Line2User> lines = recommend(loginRequest);
            loginResponse.setLines(lines);

        }else if(user.getStatus().equals( UserStatusEnum.MATCH_STATUS.getValue())){
            List<Line2User> lines = getLine(loginRequest);
            loginResponse.setLines(lines);
        }
        return loginResponse;
    }



    User getUser(LoginRequest loginRequest){
        return  new User();
    }

    List<Line2User> recommend(LoginRequest loginRequest){
        List<Line2User> lines = new ArrayList<>();
        return lines;
    }

    List<Line2User> getLine(LoginRequest loginRequest){
        List<Line2User> lines = new ArrayList<>();
        return lines;
    }
}
