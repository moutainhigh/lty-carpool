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
    /**
     * 出行时间
     */
    private Long startTime;
    /**
     * 查询时间
     */
    private Long eventTime;

    @Override
    public boolean validate() {
        return true;
    }
}
