package com.springboot.blog.comment.service.impl;

import com.springboot.blog.boot.exception.BlogAPIException;
import com.springboot.blog.comment.domain.model.Comment;
import com.springboot.blog.comment.domain.repository.CommentRepository;
import com.springboot.blog.comment.dto.request.CommentSaveRequestDto;
import com.springboot.blog.comment.dto.response.CommentPageResponseDto;
import com.springboot.blog.comment.dto.response.CommentResponseDto;
import com.springboot.blog.comment.service.CommentService;
import com.springboot.blog.post.domain.model.Post;
import com.springboot.blog.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    @Override
    @Transactional
    public CommentResponseDto createComment(Long postId, CommentSaveRequestDto commentSaveRequestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));
        Comment comment = commentSaveRequestDto.toEntity(post);

        return commentRepository.save(comment).toDto();
    }

    @Override
    @Transactional(readOnly = true)
    public CommentPageResponseDto getCommentPages(Long postId, Integer pageNo, Integer pageSize) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Comment> commentPage = commentRepository.findAllByPostId(postId, pageable);

        return CommentPageResponseDto.builder().entity(commentPage).build();
    }

    @Override
    @Transactional(readOnly = true)
    public CommentResponseDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + commentId));

        comment.commentPostValid(post);

        return comment.toDto();
    }
}




