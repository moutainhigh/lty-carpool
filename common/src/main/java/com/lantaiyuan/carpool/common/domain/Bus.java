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
 * @date: 2018/1/15$ 15:52$
 * @description:
 */
@Entity
@Data
public class Bus  implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String busId;
    Integer departBusType;
    Integer departBusSeats;
    String busPlateNumber;
    public Bus() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
