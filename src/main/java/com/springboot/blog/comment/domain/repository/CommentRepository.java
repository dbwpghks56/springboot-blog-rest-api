package com.springboot.blog.comment.domain.repository;

import com.springboot.blog.comment.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
