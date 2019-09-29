package com.vulenhtho.travelboot.repository;

import com.vulenhtho.travelboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAll();
}
