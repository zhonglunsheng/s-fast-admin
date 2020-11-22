package com.lipop.backend.exception;

import com.lipop.backend.business.common.ResponseInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author ruoyi
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    /**
     * 基础异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseInfo baseException(RuntimeException e) {
        log.error(e);
        return ResponseInfo.createFailure(e.getMessage());
    }
}
