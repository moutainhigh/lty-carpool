package com.lantaiyuan.carpool.common.constant;

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

    public ResultObject(Integer code) {
        this.code = code;
    }

    public ResultObject(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResultObject(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public ResultObject(int code, Object data, String massage) {
        this.code = code;
        this.data = data;
        this.massage = massage;
    }

}
