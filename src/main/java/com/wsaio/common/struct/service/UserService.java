package com.wsaio.common.struct.service;

import com.wsaio.common.struct.domain.dto.UserDTO;

public interface UserService {
    UserDTO getUserByUsername(String username);

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long id);
}
