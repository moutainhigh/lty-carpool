package com.lantaiyuan.carpool.charge.domain.request;

import lombok.Data;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:49$
 * @description:
 */
@Data
public class ChargeRequest {
    private Double startPlaceLon;
    private Double startPlaceLat;
    private Double endPlaceLon;
    private Double endPlaceLat;
    private String userId;
    private Long eventTime;
}
