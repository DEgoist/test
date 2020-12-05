package com.dzc.controller;

import com.dzc.service.UserService;

public class UserController {
    private UserService userService;

    public UserService getUserService(){
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
