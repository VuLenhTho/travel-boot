package com.vulenhtho.travelboot.service;

import com.vulenhtho.travelboot.model.request.UserRequest;
import com.vulenhtho.travelboot.model.response.RegisterResponse;
import com.vulenhtho.travelboot.model.response.UserResponse;

import java.util.List;

public interface UserService {
    void insert(UserRequest userRequest);

    void update(Long id, UserRequest userRequest);

    void delete(Long id);

    RegisterResponse findUserByUserName(String userName);

    List<UserResponse> findAll();
}
