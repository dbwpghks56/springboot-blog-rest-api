package com.springboot.blog.user.dto.response;

import lombok.*;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class RoleResponseDto {
    private String name;

    @Builder
    public RoleResponseDto(String name) {
        this.name = name;
    }
}
