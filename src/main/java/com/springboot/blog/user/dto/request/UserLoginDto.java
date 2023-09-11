package com.springboot.blog.user.dto.request;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class UserLoginDto {
    private String usernameOrEmail;
    private String password;
}
