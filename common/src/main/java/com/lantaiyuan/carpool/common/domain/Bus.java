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
 * @description:
 */
@Table(name="carpool_bus")
@Entity
@Data
@NoArgsConstructor
public class Bus  implements Validate,Serializable {
    @Id
    private String busId;
    private Integer departBusType;
    private Integer departBusSeats;
    private String busPlateNumber;

    @Override
    public boolean validate() {
        return true;
    }
}
