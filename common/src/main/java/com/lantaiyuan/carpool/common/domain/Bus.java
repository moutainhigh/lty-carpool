package com.lantaiyuan.carpool.common.domain;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 15:52$
 * @description: 数据库车辆信息
 */
@Table(name="carpool_bus")
@Entity
@Data
@NoArgsConstructor
public class Bus  implements Validate,Serializable {
    /**
     * 公交车id
     */
    @Id
    private String busId;
    /**
     * 车辆类型
     */
    private Integer departBusType;
    /**
     * 车辆座位数
     */
    private Integer departBusSeats;
    /**
     * 车牌号
     */
    private String busPlateNumber;

    @Override
    public boolean validate() {
        return true;
    }
}
