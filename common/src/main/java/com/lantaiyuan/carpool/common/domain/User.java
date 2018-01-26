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
 * @date: 2018/1/8$ 9:53$
 * @description:
 */
@Entity
@Data
public class User implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private Integer status;
    private String orderId;
    private String lineId;

    public User() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
