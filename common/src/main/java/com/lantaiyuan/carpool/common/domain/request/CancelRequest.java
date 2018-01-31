package com.lantaiyuan.carpool.common.domain.request;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 17:12$
 * @description:
 */
@Data
public class CancelRequest implements Validate,Serializable {
    String userId;
    Long eventTime;
    Integer cancelCode;
    Double longitude;
    Double latitude;

    @Override
    public Boolean validate() {
        return true;
    }
}
