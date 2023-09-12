package com.springboot.blog.post.domain.repository;

import com.springboot.blog.post.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategoryId(Long categoryId);
}
