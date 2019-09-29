package com.vulenhtho.travelboot.mapper;

import com.vulenhtho.travelboot.entity.Role;
import com.vulenhtho.travelboot.model.response.RoleResponse;
import com.vulenhtho.travelboot.util.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponse transferToRoleResponse(Role role){
        RoleResponse roleResponse = new RoleResponse();
        BeanUtils.refine(role,roleResponse,BeanUtils::copyNonNull);
        return roleResponse;
    }
}
