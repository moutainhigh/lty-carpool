package com.lantaiyuan.carpool.common.domain.response;

import com.lantaiyuan.carpool.common.Validate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/26$ 15:25$
 * @description:返回给用户的行程信息
 */
@Data
public class Tour4User implements Validate,Serializable {
    /**
     * 行程起始经度
     */
    private Double startLongitude;
    /**
     * 行程起始纬度
     */
    private Double startLatitude;
    /**
     * 行程结束经度
     */
    private Double endLongitude;
    /**
     * 行程结束纬度
     */
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
