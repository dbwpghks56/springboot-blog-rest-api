package com.springboot.blog.category.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
}
