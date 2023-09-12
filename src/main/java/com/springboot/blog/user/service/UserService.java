package com.springboot.blog.user.service;

import com.springboot.blog.boot.dto.response.JWTAuthResponse;
import com.springboot.blog.user.dto.request.UserLoginDto;
import com.springboot.blog.user.dto.request.UserRegisterDto;
import com.springboot.blog.user.dto.response.UserResponseDto;

public interface UserService {
    JWTAuthResponse login(UserLoginDto userLoginDto);
    UserResponseDto register(UserRegisterDto userRegisterDto);
    UserResponseDto getUserProfile();
}
