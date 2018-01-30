package com.lantaiyuan.carpool.common.domain;


import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 9:53$
 * @description:
 */
@Table(name="carpool_user")
@Entity
@Data
public class User implements Validate,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  String userId;
    private  Integer userStatus;
    private String orderId;
    private String lineId;

    public User() {
    }

    @Override
    public Boolean validate() {
        return null;
    }
}
