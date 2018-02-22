package com.lantaiyuan.carpool.common.domain.response;

import com.lantaiyuan.carpool.common.Validate;
import lombok.AllArgsConstructor;
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

    public Tour4User(double startLongitude, double startLatitude, double endLongitude, double endLatitude) {
        this.startLongitude = startLongitude;
        this.startLatitude = startLatitude;
        this.endLongitude = endLongitude;
        this.endLatitude = endLatitude;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
