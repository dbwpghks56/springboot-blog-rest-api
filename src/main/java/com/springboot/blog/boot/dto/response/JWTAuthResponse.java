package com.springboot.blog.boot.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class JWTAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
}
