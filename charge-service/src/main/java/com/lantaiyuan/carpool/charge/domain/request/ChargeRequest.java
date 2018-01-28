package com.lantaiyuan.carpool.charge.domain.request;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:49$
 * @description:
 */
@Data
public class ChargeRequest implements Validate,Serializable {
    private Double startPlaceLon;
    private Double startPlaceLat;
    private Double endPlaceLon;
    private Double endPlaceLat;
    private String userId;
    private Long eventTime;

    @Override
    public Boolean validate() {
        return true;
    }
}
