package com.springboot.blog.category.exception;

import com.springboot.blog.boot.exception.ResourceNotFoundException;

public class CategoryNotFoundException extends ResourceNotFoundException {
    public CategoryNotFoundException(Long fieldValue) {
        super("category", "id", fieldValue);
    }
}
