package com.springboot.blog.comment.exception;

import com.springboot.blog.boot.exception.ResourceNotFoundException;

public class CommentNotFoundException extends ResourceNotFoundException {
    public CommentNotFoundException(Long fieldValue) {
        super("Comment", "id", fieldValue);
    }
}
