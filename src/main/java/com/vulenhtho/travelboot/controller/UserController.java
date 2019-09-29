package com.vulenhtho.travelboot.controller;

import com.vulenhtho.travelboot.model.request.UserRequest;
import com.vulenhtho.travelboot.model.response.RegisterResponse;
import com.vulenhtho.travelboot.model.response.RoleResponse;
import com.vulenhtho.travelboot.model.response.UserResponse;
import com.vulenhtho.travelboot.service.RoleService;
import com.vulenhtho.travelboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController extends BaseController{
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostMapping("/user")
    public ResponseEntity<Void> insert(@Valid @RequestBody UserRequest userRequest){
        userService.insert(userRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody UserRequest userRequest){
        userService.update(id,userRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<RegisterResponse> getUserByUserName(@RequestParam String userName){
//        return new ResponseEntity<>(userService.findUserByUserName(userName), HttpStatus.OK);
        return ResponseEntity.ok(userService.findUserByUserName(userName));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponse>> getRoles(){
        return ResponseEntity.ok(roleService.findAll());
    }

}
