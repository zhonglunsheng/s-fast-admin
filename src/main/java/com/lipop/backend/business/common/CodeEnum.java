package com.lipop.backend.business.common;

import lombok.AllArgsConstructor;


/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-11-22 18:12
 */
@AllArgsConstructor
public enum CodeEnum {
    /**
     * 通用成功响应
     */
    COMMON_SUCCESS("0000", "操作成功"),
    /**
     * 通用操作失败
     */
    COMMON_FAILURE("1111", "操作失败"),


    ;

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
