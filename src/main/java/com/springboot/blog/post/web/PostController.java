package com.springboot.blog.post.web;

import com.springboot.blog.post.domain.model.Post;
import com.springboot.blog.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Post> createPost(
            @RequestBody Post post
    ) {
        Post postEntity = postRepository.save(post);
        return ResponseEntity.ok(postEntity);
    }
}
