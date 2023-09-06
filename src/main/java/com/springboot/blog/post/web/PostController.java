package com.springboot.blog.post.web;

import com.springboot.blog.post.domain.model.Post;
import com.springboot.blog.post.domain.repository.PostRepository;
import com.springboot.blog.post.dto.request.PostSaveRequestDto;
import com.springboot.blog.post.dto.response.PostPageResponseDto;
import com.springboot.blog.post.dto.response.PostResponseDto;
import com.springboot.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(
            @RequestBody PostSaveRequestDto postSaveRequestDto
            ) {
        return new ResponseEntity<>(postService.savePost(postSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PostPageResponseDto> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ) {
        return ResponseEntity.ok(postService.getAllPosts(pageNo, pageSize, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable Long id,
            @RequestBody PostSaveRequestDto postSaveRequestDto
            ) {
        return ResponseEntity.ok(postService.updatePost(id, postSaveRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }
}
