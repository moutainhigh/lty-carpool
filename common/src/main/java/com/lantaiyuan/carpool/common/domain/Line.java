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
    private Long lineId;
    private String cityCode;
    private String userId;
    private Integer lineStatus;
    private Integer lineExpectTime;
    private String location;
    private Integer linePersons;
    private Integer requiredPersons;
    private Integer departTime;
    private String driverId;
    private String busId;

    public Line() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
