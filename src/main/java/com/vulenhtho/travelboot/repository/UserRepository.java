package com.vulenhtho.travelboot.repository;

import com.vulenhtho.travelboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);

    List<User> findAll();
}
