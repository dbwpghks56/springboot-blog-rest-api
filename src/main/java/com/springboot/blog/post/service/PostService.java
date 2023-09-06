package com.springboot.blog.post.service;

import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostPageResponseDto;
import com.springboot.blog.post.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    PostResponseDto savePost(PostSaveRequestDto requestDto);
    PostPageResponseDto getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDir);
    PostResponseDto getPostById(Long id);
    PostResponseDto updatePost(Long id, PostSaveRequestDto requestDto);
    String deletePost(Long id);
}
