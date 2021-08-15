package com.wsaio.common.struct.exception;

import com.wsaio.common.struct.domain.pojo.ErrorEnum;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException() {
        super(ErrorEnum.USERNAME_NOT_FOUND.getResult().getMsg());
    }
}
