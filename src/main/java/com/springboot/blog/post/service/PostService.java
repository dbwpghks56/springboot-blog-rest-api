package com.springboot.blog.post.service;

import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostResponseDto;

public interface PostService {
    PostResponseDto savePost(PostSaveRequestDto requestDto);
}
