package com.ciq.application.controller;

import com.ciq.application.entity.User;
import com.ciq.application.response.BaseResponse;
import com.ciq.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/addUser")
    public BaseResponse addUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @ResponseBody
    @GetMapping("/getUserById/{id}")
    public User findUserById(@PathVariable Integer id)
    {
        return userService.getUserById(id);
    }

    @ResponseBody
    @GetMapping("/getUserByUsername/{username}")
    public User findUserByUsername(@PathVariable String username)
    {
        return userService.getUserByUsername(username);
    }
}
