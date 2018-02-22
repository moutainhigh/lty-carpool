package com.lantaiyuan.carpool.common.domain;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 11:54$
 * @description:
 */
@Table(name="carpool_order")
@Entity
@Data
@NoArgsConstructor
public class Order implements Validate,Serializable {
    @Id
    private Long orderId;
    private String cityCode;
    private String userId;
    private String userPhoneNumber;
    private String startName;
    private Double startLongitude;
    private Double startLatitude;
    private String endName;
    private Double endLongitude;
    private Double endLatitude;
    /**
     * 订单座位数
     */
    private Integer seatCount;
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

    /**
     * 是否支付
     */
    private Boolean alreadyPaid;
    /**
     * 订单状态
     */
    private Integer orderStatus;



    @Override
    public boolean validate() {
        if(!alreadyPaid){
            if(lineId==0){
                return false;
            }
        }
        return true;
    }
}
