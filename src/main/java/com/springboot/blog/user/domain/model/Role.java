package com.springboot.blog.user.domain.model;

import com.springboot.blog.user.dto.response.RoleResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public RoleResponseDto toResponseDto() {
        return RoleResponseDto.builder()
                .name(this.name)
                .build();
    };
}
