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
 * @description:数据库线路信息
 */
@Table(name="carpool_line")
@Entity
@Data
@NoArgsConstructor
public class Line implements Validate,Serializable {
    /**
     * 线路id
     */
    @Id
    private Long lineId;
    /**
     * 订单id，一条线路可能包含多条订单
     */
    private Long orderId;
    /**
     * 用户id，一条线路可能包含多个用户
     */
    private String userId;
    /**
     * 城市代码
     */
    private String cityCode;
    /**
     * 线路发车时间
     */
    private Integer departTime;
    /**
     * 线路司机id
     */
    private String driverId;
    /**
     * 线路司机id
     */
    private String busId;



    @Override
    public boolean validate() {
        return true;
    }
}
