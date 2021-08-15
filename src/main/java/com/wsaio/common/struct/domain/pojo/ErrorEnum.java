package com.wsaio.common.struct.domain.pojo;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    ERROR(1000, HttpStatus.BAD_REQUEST, "ERROR"),
    USERNAME_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "USERNAME_NOT_FOUND"),
    USER_EXISTED(1002, HttpStatus.BAD_REQUEST, "USER_EXISTED"),

    SERVER_ERROR(-1, HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_ERROR");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final ErrorResult result;

    /**
     * @param code       错误码
     * @param httpStatus http响应码
     * @param msg        错误描述
     */
    ErrorEnum(Integer code, HttpStatus httpStatus, String msg) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.result = new ErrorResult(code, msg);
    }

    public Integer getCode() {
        return this.code;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public ErrorResult getResult() {
        return this.result;
    }
}
