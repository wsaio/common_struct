package com.wsaio.common.struct.exception;

import com.wsaio.common.struct.domain.pojo.ErrorEnum;
import com.wsaio.common.struct.domain.pojo.ErrorResult;
import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final ErrorResult result;

    public AppException(ErrorEnum error) {
        super(error.getResult().getMsg());
        this.httpStatus = error.getHttpStatus();
        this.result = error.getResult();
    }

    public AppException(ErrorEnum error, Exception e) {
        super(e);
        this.httpStatus = error.getHttpStatus();
        this.result = error.getResult();
    }

    public AppException(ErrorEnum error, String msg) {
        super(msg);
        this.httpStatus = error.getHttpStatus();
        this.result = new ErrorResult(error.getCode(), msg);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorResult getResult() {
        return result;
    }
}
