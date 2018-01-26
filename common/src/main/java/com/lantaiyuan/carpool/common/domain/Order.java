package com.lantaiyuan.carpool.common.domain;

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
    Long orderId;
    String cityCode;
    String userId;
    String phoneNumber;
    String startName;
    Double startLongitude;
    Double startLatitude;
    String endName;
    Double endLongitude;
    Double endLatitude;
    Integer number;
    Integer maxWalkDistance;
    String earliestStartTime;
    String latestStartTime;
    /**
     * 订单联系人号码
     */
    String orderPhoneNumber;
    /**
     * 发起订单位置
     */
    String orderPlaceName;
    /**
     * 事件时间
     */
    Long eventTime;
    /**
     * 用户状态
     */
    Integer userStatus;
    /**
     * 线路id
     */
    Long lineId;

    public Order() {

    }

    @Override
    public Boolean validate() {
        return null;
    }
}
