package com.jg.rollingpage.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "user_password")
    private String userPassword;
    
    @Column(name = "user_email")
    private String userEmail;
    
    @Column(name = "user_nickname")
    private String userNickname;
    
    @Column(name = "user_sns")
    private String userSns;
    
    @Column(name = "create_at")
    private LocalDateTime createAt;
    
    @Column(name = "delete_at")
    private String deleteAt;

    @Builder
    public User(Integer userId, String userPassword, String userEmail, String userNickname, String userSns, LocalDateTime createAt, String deleteAt) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.userSns = userSns;
        this.createAt = createAt;
        this.deleteAt = deleteAt;
    }
}

