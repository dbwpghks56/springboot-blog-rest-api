package com.springboot.blog.comment.dto.request;

import com.springboot.blog.comment.domain.model.Comment;
import com.springboot.blog.post.domain.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CommentSaveRequestDto {
    private String name;
    private String email;
    private String body;

    public Comment toEntity(Post post) {
        return Comment.builder()
                .name(this.name)
                .email(this.email)
                .body(this.body)
                .post(post)
                .build();
    }
}
