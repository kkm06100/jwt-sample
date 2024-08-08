package com.gdsc.cmd.domain.user.domain.repository;

import com.gdsc.cmd.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByAccountId(String accountId);


}
