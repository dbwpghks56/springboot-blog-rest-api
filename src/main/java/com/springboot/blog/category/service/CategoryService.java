package com.springboot.blog.category.service;

import com.springboot.blog.category.dto.request.CategoryRequestDto;
import com.springboot.blog.category.dto.response.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
}
