package com.lantaiyuan.carpool.login.service.impl;

import com.lantaiyuan.carpool.login.domain.request.LoginRequest;
import com.lantaiyuan.carpool.login.domain.response.LoginResponse;
import com.lantaiyuan.carpool.login.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
