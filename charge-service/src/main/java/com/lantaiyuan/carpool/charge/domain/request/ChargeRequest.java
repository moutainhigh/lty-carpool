package com.lantaiyuan.carpool.charge.domain.request;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/17$ 15:49$
 * @description:计价服务请求参数
 */
@Data
public class ChargeRequest implements Validate,Serializable {
    /**
     * 订单起始经度
     */
    private Double startPlaceLon;
    /**
     * 订单起始纬度
     */
    private Double startPlaceLat;
    /**
     * 订单结束经度
     */
    private Double endPlaceLon;
    /**
     * 订单结束纬度
     */
    private Double endPlaceLat;
    /**
     * 用户id
     */
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
