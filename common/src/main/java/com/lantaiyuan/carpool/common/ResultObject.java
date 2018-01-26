package com.lantaiyuan.carpool.common;

import lombok.Data;

/**
 *
 */
@Data
public class ResultObject {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回对象
     */
    private Object data;
    /**
     * 返回异常信息
     */
    private String massage;

    public ResultObject(int code, Object data) {
        this.code = code;
        this.data = data;
    }

}
