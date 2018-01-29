package com.lantaiyuan.carpool.login.domain.request;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 17:07$
 * @description:
 */
@Data
public class LoginRequest implements Validate,Serializable {
    private String userId;
    private Long eventTime;
    private Double longitude;
    private Double latitude;

    @Override
    public Boolean validate() {
        return null;
    }
}
