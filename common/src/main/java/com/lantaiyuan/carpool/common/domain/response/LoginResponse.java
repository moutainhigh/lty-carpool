package com.lantaiyuan.carpool.common.domain.response;


import com.lantaiyuan.carpool.common.Validate;
import com.lantaiyuan.carpool.common.domain.Order;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 17:09$
 * @description: 用户登录请求返回
 */
@Data
public class LoginResponse implements Validate,Serializable {
    /**
     * 用户状态 com.lantaiyuan.carpool.common.constant.UserStatusEnum
     */
    private Integer status;
    /**
     * 线路信息，根据用户状态，空状态则推荐线路，其他状态则返回用户所在线路
     */
    private List<Line4User> lines;

    @Override
    public boolean validate() {
        return true;
    }
}
