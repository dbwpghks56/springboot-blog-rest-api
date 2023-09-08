package com.springboot.blog.comment.dto.response;

import com.springboot.blog.post.dto.response.PostResponseDto;
import lombok.*;

@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private Long id;
    private String name;
    private String email;
    private String body;
    private PostResponseDto post;
}
