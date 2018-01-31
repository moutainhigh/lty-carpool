package com.lantaiyuan.carpool.order.domain.request;


import com.lantaiyuan.carpool.common.Validate;
import com.lantaiyuan.carpool.common.domain.Order;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 17:09$
 * @description:
 */
@Data
public class NewOrderRequest  implements Validate,Serializable {
    String userId;
    Long eventTime;
    Double longitude;
    Double latitude;
    Order order;

    @Override
    public Boolean validate() {
        if(!order.validate()){
            return false;
        }
        return true;
    }
}
