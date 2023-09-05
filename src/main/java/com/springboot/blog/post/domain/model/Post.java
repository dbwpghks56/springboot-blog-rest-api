package com.springboot.blog.post.domain.model;

import com.springboot.blog.boot.domain.model.BaseEntity;
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
}









