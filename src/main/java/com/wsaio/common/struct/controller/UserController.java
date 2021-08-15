package com.wsaio.common.struct.controller;

import com.wsaio.common.struct.domain.dto.UserDTO;
import com.wsaio.common.struct.domain.pojo.ErrorEnum;
import com.wsaio.common.struct.domain.vo.UserVO;
import com.wsaio.common.struct.exception.AppException;
import com.wsaio.common.struct.exception.UsernameNotFoundException;
import com.wsaio.common.struct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id:\\d+}$id")
    public UserVO getUserById(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return userDTO.castTo(new UserVO());
    }

    @GetMapping("/users/{username:[a-zA-Z]\\w{5,19}}")
    public UserVO getUserByUsername(@PathVariable("username") String username) {
        UserDTO userDTO;
        try {
            userDTO = userService.getUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new AppException(ErrorEnum.USERNAME_NOT_FOUND, e);
        }
        return userDTO.castTo(new UserVO());
    }

    @PostMapping("/users")
    public UserVO createUser(@RequestBody UserVO userVO) {
        UserDTO user;
        try {
            user = userService.createUser(UserDTO.castFrom(userVO));
        } catch (DataIntegrityViolationException e) {
            throw new AppException(ErrorEnum.USER_EXISTED, e);
        }
        return user.castTo(new UserVO());
    }
}
