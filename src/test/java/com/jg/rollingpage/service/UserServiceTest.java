package com.jg.rollingpage.service;

import com.jg.rollingpage.domain.User;
import com.jg.rollingpage.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Test
    void test() {
        //BDD
        //given 할것인가 테스트 하기전 세팅
        User user = User.builder()
                .userNickname("가영")
                .userPassword("1234")
                .userEmail("email@email.com")
                .userSns("G")
                .build();
        given(userRepository.save(any(User.class))).willReturn(user);

        //when 무슨일이 벌어질때, ~할때
        User user1 = userService.createUser();

        //then 그래서 결과는? 무엇이다.
        assertThat(user.getUserNickname()).isEqualTo(user1.getUserNickname());
    }
}