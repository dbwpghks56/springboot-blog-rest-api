package com.springboot.blog.post.dto.response;

import com.springboot.blog.post.domain.model.Post;
import lombok.*;

import java.util.List;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private String content;

    @Builder
    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.content = entity.getContent();
    }

    public static List<PostResponseDto> listOf(List<Post> posts) {
        return posts.stream().map(PostResponseDto::new).toList();
    }
}
