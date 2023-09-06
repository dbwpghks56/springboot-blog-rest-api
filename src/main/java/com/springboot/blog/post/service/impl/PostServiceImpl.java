package com.springboot.blog.post.service.impl;

import com.springboot.blog.boot.exception.ResourceNotFoundException;
import com.springboot.blog.post.domain.model.Post;
import com.springboot.blog.post.domain.repository.PostRepository;
import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostResponseDto;
import com.springboot.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    @Transactional
    public PostResponseDto savePost(PostSaveRequestDto requestDto) {
        return PostResponseDto.builder().entity(
                postRepository.save(requestDto.toEntity())
        ).build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll().stream().map(PostResponseDto::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto getPostById(Long id) {
        Post post = checkPost(id);

        return PostResponseDto.builder().entity(post).build();
    }

    @Override
    @Transactional
    public PostResponseDto updatePost(Long id, PostSaveRequestDto requestDto) {
        Post post = checkPost(id);
        post.update(requestDto);

        return PostResponseDto.builder().entity(post).build();
    }

    @Override
    @Transactional
    public String deletePost(Long id) {
        Post post = checkPost(id);
        postRepository.delete(post);

        return "Post deleted successfully";
    }

    private Post checkPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }
}
