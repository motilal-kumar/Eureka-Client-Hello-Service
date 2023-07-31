package com.neosoft.eurekaclienthelloservice.controller;


import com.neosoft.eurekaclienthelloservice.entity.User;
import com.neosoft.eurekaclienthelloservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(
            @RequestBody User user) {
        User savedUser = userService.saveUserData(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }



    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable  String userId){

      User user =   userService.getUser(userId);

        return ResponseEntity.ok(user) ;
    }


    @GetMapping("/all-users")
    public ResponseEntity<List<User>>  getAllUser(){

      List<User> userList =  userService.findAllUserData();


        return ResponseEntity.ok(userList);
    }

}
