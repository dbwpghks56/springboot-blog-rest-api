package com.springboot.blog.user.service;

import com.springboot.blog.user.dto.request.UserLoginDto;
import com.springboot.blog.user.dto.response.UserResponseDto;

public interface UserService {
    UserResponseDto login(UserLoginDto userLoginDto);
}
