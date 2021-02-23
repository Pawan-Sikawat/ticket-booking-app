package com.ciq.application.service;

import com.ciq.application.respository.UserRepository;
import com.ciq.application.entity.User;
import com.ciq.application.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public BaseResponse saveUser(User user)
    {
        BaseResponse response = new BaseResponse();
        userRepository.save(user);
        response.setResponseCode(BaseResponse.SUCCESS_RESPONSE_DEFAULT);
        response.setResponseMessage("User Registration Successfull");
        return response;
    }

    public User getUserById(Integer id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username); 
    }
}
