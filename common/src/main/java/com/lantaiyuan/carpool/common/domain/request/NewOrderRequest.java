package com.lantaiyuan.carpool.common.domain.request;


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
    private String userId;
    private Long eventTime;
    private Double longitude;
    private Double latitude;
    private Order order;

    @Override
    public boolean validate() {
        if(!order.validate()){
            return false;
        }
        return true;
    }
}
