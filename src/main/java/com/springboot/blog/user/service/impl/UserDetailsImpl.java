package com.springboot.blog.user.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.blog.user.domain.model.Role;
import com.springboot.blog.user.domain.model.User;
import com.springboot.blog.user.dto.response.UserResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private Long seq;
    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private String email;
    private Set<Role> roles;

    public UserResponseDto toResponseDto() {
        return UserResponseDto.builder()
                .id(this.seq)
                .username(this.username)
                .email(this.email)
                .name(this.name)
                .roles(this.roles.stream().map(Role::toResponseDto).collect(Collectors.toSet()))
                .build();
    }

    @Builder
    public UserDetailsImpl(Long seq, String username, String password, String name, String email, Set<Role> roles) {
        this.seq = seq;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
