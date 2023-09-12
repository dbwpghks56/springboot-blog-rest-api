package com.springboot.blog.category.dto.request;

import com.springboot.blog.category.domain.model.Category;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class CategoryRequestDto {
    private String name;
    private String description;

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .description(description)
                .build();
    }
}
