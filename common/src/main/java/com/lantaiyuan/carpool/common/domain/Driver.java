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
 * @description:数据库司机信息
 */
@Table(name="carpool_driver")
@Entity
@Data
@NoArgsConstructor
public class Driver implements Validate,Serializable {
    /**
     * 司机id
     */
    @Id
    private String driverId;
    /**
     * 司机名字
     */
    private String driverName;
    /**
     * 司机评价
     */
    private Integer driverJudgement;
    /**
     * 司机手机号
     */
    private String driverPhoneNumber;

    @Override
    public boolean validate() {
        return true;
    }
}
