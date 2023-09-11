package com.springboot.blog.user.dto.response;

import com.springboot.blog.user.domain.model.Role;
import com.springboot.blog.user.service.impl.UserDetailsImpl;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String name;
    private Set<RoleResponseDto> roles;

    @Builder
    public UserResponseDto(UserDetailsImpl userDetails) {
        this.id = userDetails.getSeq();
        this.username = userDetails.getUsername();
        this.email = userDetails.getEmail();
        this.name = userDetails.getName();
        this.roles = userDetails.getRoles().stream().map(Role::toResponseDto).collect(Collectors.toSet());
    }
}
