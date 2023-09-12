package com.springboot.blog.category.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.blog.boot.domain.model.BaseEntity;
import com.springboot.blog.post.domain.model.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Table(name ="tb_category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"posts"})
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Post> posts;
}







