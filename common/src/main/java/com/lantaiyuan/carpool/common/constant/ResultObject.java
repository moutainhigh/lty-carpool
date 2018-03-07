package com.lantaiyuan.carpool.common.constant;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Administrator$
 * @project: lty-carpool$
 * @date: 2018/1/9$ 15:39$
 * @description:返回客户端数据包装
 */
@Data
@NoArgsConstructor
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

    public ResultObject(int code) {
        this.code = code;
    }

    public ResultObject(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResultObject(int code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public ResultObject(int code, Object data, String massage) {
        this.code = code;
        this.data = data;
        this.massage = massage;
    }

}
