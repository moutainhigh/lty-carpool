package com.lantaiyuan.carpool.common.domain.response;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/26$ 15:26$
 * @description:
 */
@Data
public class Line4User implements Validate,Serializable {
    private Long lineId;
    private String cityCode;
    private Integer lineStatus;
    private Long lineExpectTime;
    private List<Tour4User> tours;
    private Integer linePersons;
    private Integer requiredPersons;
    private Long departTime;
    private String driverId;
    private String busId;

    @Override
    public boolean validate() {
        return true;
    }
}
