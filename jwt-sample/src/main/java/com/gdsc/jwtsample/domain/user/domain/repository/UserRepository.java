package com.gdsc.jwtsample.domain.user.domain.repository;

import com.gdsc.jwtsample.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {
}
