package com.springboot.blog.post.service.impl;

import com.springboot.blog.boot.exception.ResourceNotFoundException;
import com.springboot.blog.category.domain.model.Category;
import com.springboot.blog.category.domain.repository.CategoryRepository;
import com.springboot.blog.category.exception.CategoryNotFoundException;
import com.springboot.blog.post.domain.model.Post;
import com.springboot.blog.post.domain.repository.PostRepository;
import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostPageResponseDto;
import com.springboot.blog.post.dto.response.PostResponseDto;
import com.springboot.blog.post.exception.PostNotFoundException;
import com.springboot.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    @Override
    @Transactional
    public PostResponseDto savePost(PostSaveRequestDto requestDto) {
        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(requestDto.getCategoryId()));

        Post post = postRepository.save(requestDto.toEntity(category));

        return mapper.map(post, PostResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PostPageResponseDto getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagedResult = postRepository.findAll(pageable);

        return mapper.map(pagedResult, PostPageResponseDto.class);
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
        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(requestDto.getCategoryId()));
        Post post = checkPost(id);

        post.update(requestDto,category);

        return PostResponseDto.builder().entity(post).build();
    }

    @Override
    @Transactional
    public String deletePost(Long id) {
        Post post = checkPost(id);
        postRepository.delete(post);

        return "Post deleted successfully";
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponseDto> getPostsByCategoryId(Long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        List<Post> posts = postRepository.findAllByCategoryId(categoryId);

        return posts.stream().map(PostResponseDto::new).toList();
    }

    private Post checkPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }
}
