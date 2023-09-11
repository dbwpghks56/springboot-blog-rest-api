package com.springboot.blog.user.web;

import com.springboot.blog.user.dto.request.UserLoginDto;
import com.springboot.blog.user.dto.request.UserRegisterDto;
import com.springboot.blog.user.dto.response.UserResponseDto;
import com.springboot.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<UserResponseDto> login(
            @RequestBody UserLoginDto userLoginDto
            ) {
        return ResponseEntity.ok(userService.login(userLoginDto));
    }

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<UserResponseDto> register(
            @RequestBody UserRegisterDto userRegisterDto
            ) {
        return new ResponseEntity<>(userService.register(userRegisterDto), HttpStatus.CREATED);
    }
}
