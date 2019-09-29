package com.vulenhtho.travelboot.mapper;

import com.vulenhtho.travelboot.entity.User;
import com.vulenhtho.travelboot.model.request.UserRequest;
import com.vulenhtho.travelboot.model.response.RegisterResponse;
import com.vulenhtho.travelboot.model.response.RoleResponse;
import com.vulenhtho.travelboot.model.response.UserResponse;
import com.vulenhtho.travelboot.util.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private RoleMapper roleMapper;

    public User transferToUser(UserRequest userRequest){
        User user = new User();
        BeanUtils.refine(userRequest,user, BeanUtils::copyNonNull);

        return user;
    }

    public UserResponse transferToUserResponse(User user){
        UserResponse userResponse = new UserResponse();

        BeanUtils.refine(user, userResponse,BeanUtils::copyNonNull);
        return userResponse;
    }
    public RegisterResponse transferToRegister(User user){
        RegisterResponse registerResponse =new RegisterResponse();

        Set<RoleResponse> roleResponses = user.getRoles().stream()
                .map(roleMapper::transferToRoleResponse)
                .collect(Collectors.toSet());
        BeanUtils.refine(user, registerResponse,BeanUtils::copyNonNull);
        registerResponse.setRoles(roleResponses);
        return registerResponse;
    }

}
