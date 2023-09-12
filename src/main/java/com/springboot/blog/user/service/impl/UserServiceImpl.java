package com.springboot.blog.user.service.impl;

import com.springboot.blog.boot.auth.JwtTokenProvider;
import com.springboot.blog.boot.dto.response.JWTAuthResponse;
import com.springboot.blog.boot.exception.BlogAPIException;
import com.springboot.blog.user.domain.model.Role;
import com.springboot.blog.user.domain.model.User;
import com.springboot.blog.user.domain.repository.RoleRepository;
import com.springboot.blog.user.domain.repository.UserRepository;
import com.springboot.blog.user.dto.request.UserLoginDto;
import com.springboot.blog.user.dto.request.UserRegisterDto;
import com.springboot.blog.user.dto.response.UserResponseDto;
import com.springboot.blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public JWTAuthResponse login(UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginDto.getUsernameOrEmail(),
                userLoginDto.getPassword()
        ));
        log.info(userLoginDto.getUsernameOrEmail());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return JWTAuthResponse.builder().accessToken(token).tokenType("Bearer ").build();
    }

    @Override
    @Transactional
    public UserResponseDto register(UserRegisterDto userRegisterDto) {
        // add check for username exists in db
        if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }

        // add check for email in database
        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already taken!");
        }

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new BlogAPIException(HttpStatus.INTERNAL_SERVER_ERROR, "User Role not set."));
        roles.add(userRole);

        User user = userRegisterDto.toEntity(passwordEncoder.encode(userRegisterDto.getPassword()), roles);

        userRepository.save(user);

        return user.toResponseDto();
    }

    @Override
    @Transactional
    public UserResponseDto getUserProfile() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails.toResponseDto();
    }
}









