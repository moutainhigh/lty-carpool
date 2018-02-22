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
    private String userId;
    private Long eventTime;
    private Integer cancelCode;
    private Double longitude;
    private Double latitude;

    @Override
    public boolean validate() {
        return true;
    }
}
