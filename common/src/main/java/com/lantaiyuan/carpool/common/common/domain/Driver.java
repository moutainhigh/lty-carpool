package com.lantaiyuan.carpool.common.common.domain;

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
public class Driver implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String driverId;
    private String driverName;
    private Integer driverJudgement;
    private String driverPhoneNo;

    public Driver() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
