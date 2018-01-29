package com.lantaiyuan.carpool.common.domain.entity;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 11:54$
 * @description:
 */
@Entity
@Data
public class Order implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String cityCode;
    private String userId;
    private String phoneNumber;
    private String startName;
    private Double startLongitude;
    private Double startLatitude;
    private String endName;
    private Double endLongitude;
    private Double endLatitude;
    private Integer number;
    private Integer maxWalkDistance;
    private String earliestStartTime;
    private String latestStartTime;
    /**
     * 订单联系人号码
     */
    private String orderPhoneNumber;
    /**
     * 发起订单位置
     */
    private String orderPlaceName;
    /**
     * 事件时间
     */
    private Long eventTime;
    /**
     * 用户状态
     */
    private Integer userStatus;
    /**
     * 线路id
     */
    private Long lineId;

    public Order() {

    }

    @Override
    public Boolean validate() {
        return null;
    }
}
