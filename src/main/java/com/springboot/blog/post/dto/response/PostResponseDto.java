package com.springboot.blog.post.dto.response;

import com.springboot.blog.comment.domain.model.Comment;
import com.springboot.blog.comment.dto.response.CommentResponseDto;
import com.springboot.blog.post.domain.model.Post;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private String content;

    private Set<CommentResponseDto> comments;

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
