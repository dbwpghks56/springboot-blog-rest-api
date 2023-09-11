package com.springboot.blog.comment.dto.request;

import com.springboot.blog.comment.domain.model.Comment;
import com.springboot.blog.post.domain.model.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CommentSaveRequestDto {
    @NotEmpty
    @Size(min = 2, message = "이름은 2글자 이상 입력해주세요.")
    private String name;
    @NotEmpty
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;
    @NotEmpty
    @Size(min = 10, message = "내용은 10글자 이상 입력해주세요.")
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
