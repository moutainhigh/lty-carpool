package com.lantaiyuan.carpool.common.domain;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/15$ 15:52$
 * @description:
 */
@Table(name="carpool_bus")
@Entity
@Data
public class Bus  implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String busId;
    private Integer departBusType;
    private Integer departBusSeats;
    private String busPlateNumber;
    public Bus() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
