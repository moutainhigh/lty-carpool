package com.lantaiyuan.carpool.websocket.domain;
import com.lantaiyuan.carpool.common.Validate;
import com.lantaiyuan.carpool.common.common.domain.Line;
import lombok.Data;
import org.hibernate.criterion.Order;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/16$ 10:07$
 * @description:
 */
@Data
public class WebSocketResponse implements Validate,Serializable {
    int status;
    Order order;
    Line line;

    @Override
    public Boolean validate() {
        return null;
    }
}
