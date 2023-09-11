package com.springboot.blog.user.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.blog.user.domain.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

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
    private Set<GrantedAuthority> roles;

    @Builder
    public UserDetailsImpl(Long seq, String username, String password, String name, String email, Set<GrantedAuthority> roles) {
        this.seq = seq;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public static UserDetailsImpl build(User user) {
        return UserDetailsImpl.builder()
                .seq(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .roles(user.getAuthorities())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
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
