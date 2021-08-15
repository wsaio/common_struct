package com.wsaio.common.struct.repository;

import com.wsaio.common.struct.domain.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPO, Long> {
    UserPO getByUsername(String username);
}
