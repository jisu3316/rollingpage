package com.jg.rollingpage.repository;


import com.jg.rollingpage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
