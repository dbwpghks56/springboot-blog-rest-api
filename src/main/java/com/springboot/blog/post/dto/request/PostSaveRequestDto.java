package com.springboot.blog.post.dto.request;

import com.springboot.blog.post.domain.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String description;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .description(description)
                .build();
    }
}
