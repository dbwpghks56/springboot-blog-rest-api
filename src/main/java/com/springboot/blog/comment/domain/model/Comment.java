package com.springboot.blog.comment.domain.model;

import com.springboot.blog.boot.domain.model.BaseEntity;
import com.springboot.blog.boot.exception.BlogAPIException;
import com.springboot.blog.comment.dto.request.CommentSaveRequestDto;
import com.springboot.blog.comment.dto.response.CommentPageResponseDto;
import com.springboot.blog.comment.dto.response.CommentResponseDto;
import com.springboot.blog.post.domain.model.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "tb_comment")
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "comment_seq")
    @SequenceGenerator(allocationSize = 50,
            name = "comment_seq",
            sequenceName = "comment_seq"
    )
    private Long id;
    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public CommentResponseDto toDto() {
        return CommentResponseDto.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .body(this.body)
                .build();
    }

    public void commentPostValid(Post post) {
        if(!this.post.commentPostValid(post)) throw new BlogAPIException(HttpStatus.BAD_REQUEST, "댓글을 단 게시글이 존재하지 않습니다.");
    }

    public void update(CommentSaveRequestDto requestDto) {
        if (requestDto.getName() != null) {
            this.name = requestDto.getName();
        }
        if (requestDto.getEmail() != null) {
            this.email = requestDto.getEmail();
        }
        if (requestDto.getBody() != null) {
            this.body = requestDto.getBody();
        }
    }
}





