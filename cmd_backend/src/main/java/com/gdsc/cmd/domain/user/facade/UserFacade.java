package com.gdsc.cmd.domain.user.facade;

import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    public Optional<User> getCurrentUser() {
        // 인증 가능한 유저를 확인
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId);
    }

    public User getByAccountId(String accontId){
        // 유저 검색
        return userRepository.findByAccountId(accontId).orElseThrow(
                ()->new UsernameNotFoundException("")
        );
    }

    public User getUserById(Long userId) {
        // 기본 키로 검색
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    public void checkUserExists(String accountId) {
        // 유저가 없는지 확인
        if (userRepository.findByAccountId(accountId).isPresent()) {
            throw new RuntimeException("");
        }
    }

}
