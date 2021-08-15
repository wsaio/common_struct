package com.wsaio.common.struct;

import com.wsaio.common.struct.domain.pojo.ErrorEnum;
import com.wsaio.common.struct.domain.pojo.ErrorResult;
import com.wsaio.common.struct.exception.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 全局异常处理
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ErrorResult> appExceptionHandler(AppException e) {
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(e.getHttpStatus()).body(e.getResult());
    }

    /**
     * 其他异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResult> exceptionHandler(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return ResponseEntity.status(ErrorEnum.SERVER_ERROR.getHttpStatus()).body(ErrorEnum.SERVER_ERROR.getResult());
    }
}