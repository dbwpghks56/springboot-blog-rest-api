package com.springboot.blog.post.service;

import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto savePost(PostSaveRequestDto requestDto);
    List<PostResponseDto> getAllPosts();
    PostResponseDto getPostById(Long id);
    PostResponseDto updatePost(Long id, PostSaveRequestDto requestDto);
}
