package com.vulenhtho.travelboot.service.impl;

import com.vulenhtho.travelboot.entity.Role;
import com.vulenhtho.travelboot.entity.User;
import com.vulenhtho.travelboot.mapper.UserMapper;
import com.vulenhtho.travelboot.model.request.UserRequest;
import com.vulenhtho.travelboot.model.response.RegisterResponse;
import com.vulenhtho.travelboot.model.response.UserResponse;
import com.vulenhtho.travelboot.repository.RoleRepository;
import com.vulenhtho.travelboot.repository.UserRepository;
import com.vulenhtho.travelboot.service.UserService;
import com.vulenhtho.travelboot.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public void insert(UserRequest userRequest) {
        User user = userMapper.transferToUser(userRequest);

        for (Long id : userRequest.getIds()) {
            Role role = roleRepository.getOne(id);
            user.getRoles().add(role);
        }
        Date date = new Date();

        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserRequest userRequest) {
        Optional<User> userExist = userRepository.findById(id);

        User newUser = userMapper.transferToUser(userRequest);
        newUser.setStatus(userExist.get().isStatus());
        newUser.setId(id);
        for (Long i : userRequest.getIds()) {
            Role role = roleRepository.getOne(i);
            newUser.getRoles().add(role);
        }

        userRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.getOne(id);

        for (Role role : user.getRoles()) {
            role.getUser().remove(user);
        }
        userRepository.delete(user);
    }

    @Override
    public RegisterResponse findUserByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);
        RegisterResponse registerResponse = new RegisterResponse();
        BeanUtils.refine(user, registerResponse,BeanUtils::copyNonNull);
        return registerResponse;
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserResponse> userResponses = new ArrayList<>();
        UserMapper userMapper = new UserMapper();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            userResponses.add(userMapper.transferToUserResponse(user));
        }
        return userResponses;
    }
}
