package com.springboot.blog.post.service.impl;

import com.springboot.blog.post.domain.repository.PostRepository;
import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostResponseDto;
import com.springboot.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public PostResponseDto savePost(PostSaveRequestDto requestDto) {
        return PostResponseDto.builder().entity(
                postRepository.save(requestDto.toEntity())
        ).build();
    }
}
