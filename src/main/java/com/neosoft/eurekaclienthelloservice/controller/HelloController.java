package com.neosoft.eurekaclienthelloservice.controller;


import com.neosoft.eurekaclienthelloservice.entity.User;
import com.neosoft.eurekaclienthelloservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class HelloController {

    @Autowired
    private IUserService userService;


    @PostMapping("/save")
    public ResponseEntity<User> saveUser(
            @RequestBody User user) {
        User savedUser = userService.saveUserData(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/hello/{name}")
    public String sayHello(@PathVariable("name") String name){

        return "Hello, " + name;
    }


    @GetMapping("/users")
    public List<User> getAllUserData(){
        return userService.findAllUserData();
    }

}
