package com.lantaiyuan.carpool.common.domain;


import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/8$ 9:53$
 * @description: 数据库用户信息
 */
@Table(name="carpool_user")
@Entity
@Data
@NoArgsConstructor
public class User implements Validate,Serializable {
    /**
     * 用户id
     */
    @Id
    private  String userId;
    /**
     * 用户状态 com.lantaiyuan.carpool.common.constant.UserStatusEnum
     */
    private  Integer userStatus;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 线路id
     */
    private Long lineId;


    @Override
    public boolean validate() {
        return true;
    }
}
