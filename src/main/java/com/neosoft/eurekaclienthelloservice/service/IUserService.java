package com.neosoft.eurekaclienthelloservice.service;

import com.neosoft.eurekaclienthelloservice.entity.User;

import java.util.List;

public interface IUserService {
    public User saveUserData(User user);

    public List<User> findAllUserData();

    public User getUser(String userId);


}
