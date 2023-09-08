package com.springboot.blog.post.exception;

import com.springboot.blog.boot.exception.ResourceNotFoundException;

public class PostNotFoundException extends ResourceNotFoundException {
    public PostNotFoundException(Long fieldValue) {
        super("Post", "id", fieldValue);
    }
}
