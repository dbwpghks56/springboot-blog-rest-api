package com.springboot.blog.post.dto.response;

import com.springboot.blog.post.domain.model.Post;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@Setter
public class PostPageResponseDto {
    private List<PostResponseDto> content;
    private Long totalElements;
    private Integer totalPages;
    private Integer pageNo;
    private Integer pageSize;
    private boolean last;

    @Builder
    public PostPageResponseDto(Page<Post> entity) {
        this.content = PostResponseDto.listOf(entity.getContent());
        this.totalElements = entity.getTotalElements();
        this.totalPages = entity.getTotalPages();
        this.pageNo = entity.getNumber();
        this.pageSize = entity.getSize();
        this.last = entity.isLast();
    }
}
