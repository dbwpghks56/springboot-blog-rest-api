package com.springboot.blog.post.dto.request;

import com.springboot.blog.category.domain.model.Category;
import com.springboot.blog.post.domain.model.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PostSaveRequestDto {
    @NotEmpty
    @Size(min = 2, message = "제목은 2글자 이상 입력해주세요.")
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    @Size(min = 10, message = "내용은 10글자 이상 입력해주세요.")
    private String description;
    private Long categoryId;

    public Post toEntity(Category category) {
        return Post.builder()
                .title(title)
                .content(content)
                .description(description)
                .category(category)
                .build();
    }
}
