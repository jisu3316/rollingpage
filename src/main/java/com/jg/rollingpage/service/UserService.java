package com.jg.rollingpage.service;

import com.jg.rollingpage.domain.User;
import com.jg.rollingpage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser() {
        User user = User.builder()
                .userNickname("가영")
                .userPassword("1234")
                .userEmail("email@email.com")
                .userSns("G")
                .build();
        return userRepository.save(user);
    }
}
