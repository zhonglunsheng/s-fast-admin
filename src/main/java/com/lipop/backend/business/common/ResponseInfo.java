package com.lipop.backend.business.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhonglunsheng
 * @Description 通用响应封装
 * @create 2020-11-22 18:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseInfo<T> {
    public String code;
    public String msg;
    public T data;

    public static <T> ResponseInfo createSuccess() {
        return new ResponseInfo<T>(CodeEnum.COMMON_SUCCESS.getCode(), CodeEnum.COMMON_SUCCESS.getMessage(), null);
    }


    public static <T> ResponseInfo<T> createSuccess(T data) {
        return new ResponseInfo<T>(CodeEnum.COMMON_SUCCESS.getCode(), CodeEnum.COMMON_SUCCESS.getMessage(), data);
    }

    public static <T> ResponseInfo<T> createFailure() {
        return new ResponseInfo<T>(CodeEnum.COMMON_SUCCESS.getCode(), CodeEnum.COMMON_SUCCESS.getMessage(), null);
    }

    public static <T> ResponseInfo<T> createFailure(T data) {
        return new ResponseInfo<T>(CodeEnum.COMMON_FAILURE.getCode(), CodeEnum.COMMON_FAILURE.getMessage(), data);
    }

    public static <T> ResponseInfo<T> createCustomInfo(CodeEnum codeEnum, T data) {
        return new ResponseInfo<T>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }


}
