package com.wsaio.common.struct.domain.dto;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String nickname;
    private String avatarUrl;

    public <T> T castTo(T t) {
        BeanUtils.copyProperties(this, t);
        return t;
    }

    public static UserDTO castFrom(Object o) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(o, userDTO);
        return userDTO;
    }
}
