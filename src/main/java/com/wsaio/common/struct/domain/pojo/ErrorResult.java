package com.wsaio.common.struct.domain.pojo;

import lombok.Data;

@Data
public class ErrorResult {
    private Integer code;
    private String msg;

    public ErrorResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
