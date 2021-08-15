package com.wsaio.common.struct.domain.po;

import com.wsaio.common.struct.domain.dto.UserDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Table(name = "tb_user")
@Entity
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", columnDefinition = "用户名")
    private String username;
    @Column(name = "nickname", columnDefinition = "昵称")
    private String nickname;
    @Column(name = "avatar_url", columnDefinition = "头像地址")
    private String avatarUrl;

    public UserDTO alterToDto() {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(this, userDTO);
        return userDTO;
    }
}
