package com.springboot.blog.post.dto.response;

import com.springboot.blog.post.domain.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class PostPageResponseDto {
    private List<PostResponseDto> posts;
    private Long totalElements;
    private Integer totalPages;
    private Integer pageNo;
    private Integer pageSize;
    private boolean last;

    @Builder
    public PostPageResponseDto(Page<Post> entity) {
        this.posts = PostResponseDto.listOf(entity.getContent());
        this.totalElements = entity.getTotalElements();
        this.totalPages = entity.getTotalPages();
        this.pageNo = entity.getNumber();
        this.pageSize = entity.getSize();
        this.last = entity.isLast();
    }
}
