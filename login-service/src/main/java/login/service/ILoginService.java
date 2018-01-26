package login.service;

import login.domain.request.LoginRequest;
import login.domain.response.LoginResponse;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/11$ 9:40$
 * @description:
 */
public interface ILoginService {
    /**
     *
     * @param loginRequest
     * @return
     */
    LoginResponse getUserStatusOrRecommend(LoginRequest loginRequest);
}
