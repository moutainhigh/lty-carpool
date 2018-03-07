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
 * @description:数据库订单信息
 */
@Table(name="carpool_order")
@Entity
@Data
@NoArgsConstructor
public class Order implements Validate,Serializable {
    /**
     * 订单id
     */
    @Id
    private Long orderId;
    /**
     * 城市代码
     */
    private String cityCode;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户电话号码
     */
    private String userPhoneNumber;
    /**
     * 订单起始点名称
     */
    private String startName;
    /**
     * 起始点经度
     */
    private Double startLongitude;
    /**
     * 起始点纬度
     */
    private Double startLatitude;
    /**
     * 订单终点名称
     */
    private String endName;
    /**
     * 终点经度
     */
    private Double endLongitude;
    /**
     * 终点纬度
     */
    private Double endLatitude;
    /**
     * 订单座位数
     */
    private Integer seatCount;
    /**
     * 最大步行距离
     */
    private Integer maxWalkDistance;
    /**
     * 最早出发时间
     */
    private String earliestStartTime;
    /**
     * 最晚出发时间
     */
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
     * 订单状态  com.lantaiyuan.carpool.common.constant.OrderStatusEnum
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
