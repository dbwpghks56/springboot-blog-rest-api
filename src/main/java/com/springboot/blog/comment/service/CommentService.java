package com.springboot.blog.comment.service;

import com.springboot.blog.comment.dto.request.CommentSaveRequestDto;
import com.springboot.blog.comment.dto.response.CommentPageResponseDto;
import com.springboot.blog.comment.dto.response.CommentResponseDto;

public interface CommentService {
    CommentResponseDto createComment(Long postId, CommentSaveRequestDto commentSaveRequestDto);
    CommentPageResponseDto getCommentPages(Long postId, Integer pageNo, Integer pageSize);
}
