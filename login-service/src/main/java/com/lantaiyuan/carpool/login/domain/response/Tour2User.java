package com.lantaiyuan.carpool.login.domain.response;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/26$ 15:25$
 * @description:
 */
@Data
public class Tour2User implements Validate,Serializable {
    private Double startLongitude;
    private Double startLatitude;
    private Double endLongitude;
    private Double endLatitude;

    @Override
    public Boolean validate() {
        return null;
    }
}
