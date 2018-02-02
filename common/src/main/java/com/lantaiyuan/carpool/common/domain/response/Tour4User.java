package com.lantaiyuan.carpool.common.domain.response;

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
public class Tour4User implements Validate,Serializable {
    private Double startLongitude;
    private Double startLatitude;
    private Double endLongitude;
    private Double endLatitude;

    @Override
    public Boolean validate() {
        return true;
    }

    public Tour4User(Double startLongitude, Double startLatitude, Double endLongitude, Double endLatitude) {
        this.startLongitude = startLongitude;
        this.startLatitude = startLatitude;
        this.endLongitude = endLongitude;
        this.endLatitude = endLatitude;
    }
}
