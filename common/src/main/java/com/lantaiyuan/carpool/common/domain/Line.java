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
public class Line implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long lineId;
    String cityCode;
    String userId;
    Integer lineStatus;
    Integer lineExpectTime;
    String location;
    Integer linePersons;
    Integer requiredPersons;
    Integer departTime;
    String driverId;
    String busId;

    public Line() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
