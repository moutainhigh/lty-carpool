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
 * @description:
 */
@Data
public class LoginResponse implements Validate,Serializable {
    private Integer status;
    private Order order;
    private List<Line2User> lines;

    @Override
    public Boolean validate() {
        return true;
    }
}
