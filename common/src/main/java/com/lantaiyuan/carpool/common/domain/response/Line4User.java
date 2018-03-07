package com.lantaiyuan.carpool.common.domain.response;

import com.lantaiyuan.carpool.common.Validate;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/26$ 15:26$
 * @description: 返回给用户的线路信息，线路信息包含了用户所在线路所包含的所有行程信息，及车辆信息
 */
@Data
public class Line4User implements Validate,Serializable {
    /**
     * 线路id
     */
    private Long lineId;
    /**
     * 城市代码
     */
    private String cityCode;
    /**
     * 线路状态 package com.lantaiyuan.carpool.common.constant.LineStatusEnum
     */
    private Integer lineStatus;
    /**
     * 线路预计到达时间
     */
    private Long lineExpectTime;
    /**
     * 该线路所包含的行程列表
     */
    private List<Tour4User> tours;
    /**
     * 线路要求人数
     */
    private Integer requiredPersons;
    /**
     * 线路发车时间，拼车中可为空
     */
    private Long departTime;
    /**
     * 线路司机id
     */
    private String driverId;
    /**
     * 线路车辆id
     */
    private String busId;

    @Override
    public boolean validate() {
        return true;
    }
}
