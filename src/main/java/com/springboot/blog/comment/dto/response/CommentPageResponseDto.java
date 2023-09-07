package com.springboot.blog.comment.dto.response;

import com.springboot.blog.comment.domain.model.Comment;
import com.springboot.blog.post.dto.response.PostResponseDto;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentPageResponseDto {
    private List<CommentResponseDto> comments;
    private Long totalElements;
    private Integer totalPages;
    private Integer pageNo;
    private Integer pageSize;
    private boolean last;

    @Builder
    public CommentPageResponseDto(Page<Comment> entity) {
        this.comments = entity.getContent().stream().map(Comment::toDto).toList();
        this.totalElements = entity.getTotalElements();
        this.totalPages = entity.getTotalPages();
        this.pageNo = entity.getNumber();
        this.pageSize = entity.getSize();
        this.last = entity.isLast();
    }
}
