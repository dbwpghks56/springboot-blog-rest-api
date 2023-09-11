package com.springboot.blog.user.dto.request;

import com.springboot.blog.user.domain.model.Role;
import com.springboot.blog.user.domain.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@NoArgsConstructor
public class UserRegisterDto {
    private String username;
    private String email;
    private String password;
    private String name;

    public User toEntity(String encodedPassword, Set<Role> roles) {
        return User.builder()
                .username(username)
                .email(email)
                .password(encodedPassword)
                .name(name)
                .roles(roles)
                .build();
    }
}
