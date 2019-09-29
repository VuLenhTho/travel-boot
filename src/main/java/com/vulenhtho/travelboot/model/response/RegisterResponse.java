package com.vulenhtho.travelboot.model.response;

import com.vulenhtho.travelboot.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class RegisterResponse {
    private String userName;
    private String password;
    private Set<RoleResponse> roles = new HashSet<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleResponse> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleResponse> roles) {
        this.roles = roles;
    }
}
