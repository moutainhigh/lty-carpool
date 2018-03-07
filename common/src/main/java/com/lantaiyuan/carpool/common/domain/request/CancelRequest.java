package com.lantaiyuan.carpool.common.domain.request;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 17:12$
 * @description:取消订单请求
 */
@Data
public class CancelRequest implements Validate,Serializable {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户取消订单的事件时间
     */
    private Long eventTime;
    /**
     * 用户事件编码
     */
    private Integer eventCode;
    /**
     * 用户事件经度
     */
    private Double longitude;
    /**
     * 用户事件纬度
     */
    private Double latitude;

    @Override
    public boolean validate() {
        return true;
    }
}
