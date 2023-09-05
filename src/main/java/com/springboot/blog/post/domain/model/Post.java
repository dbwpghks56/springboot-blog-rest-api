package com.springboot.blog.post.domain.model;

import com.springboot.blog.boot.domain.model.BaseEntity;
import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
    name = "tb_post",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_post_title",
            columnNames = "title"
        )
    }
)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_seq"
    )
    @SequenceGenerator(
            allocationSize = 1,
            name = "post_seq",
            sequenceName = "post_seq"
    )
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;

    public void update(PostSaveRequestDto requestDto) {
        if (requestDto.getTitle() != null) {
            this.title = requestDto.getTitle();
        }
        if (requestDto.getDescription() != null) {
            this.description = requestDto.getDescription();
        }
        if (requestDto.getContent() != null) {
            this.content = requestDto.getContent();
        }
    }
}










