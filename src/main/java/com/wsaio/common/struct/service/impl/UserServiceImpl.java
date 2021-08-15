package com.wsaio.common.struct.service.impl;

import com.wsaio.common.struct.domain.dto.UserDTO;
import com.wsaio.common.struct.domain.po.UserPO;
import com.wsaio.common.struct.exception.UsernameNotFoundException;
import com.wsaio.common.struct.repository.UserRepository;
import com.wsaio.common.struct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserByUsername(String username) {
        UserPO userPO = userRepository.getByUsername(username);
        if (userPO == null) throw new UsernameNotFoundException();
        return userPO.alterToDto();
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        UserPO userPO = userRepository.save(user.castTo(new UserPO()));
        return UserDTO.castFrom(userPO);
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserPO userPO = userRepository.getById(id);
        return userPO.alterToDto();
    }
}
