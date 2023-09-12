package com.springboot.blog.category.service;

import com.springboot.blog.category.dto.request.CategoryRequestDto;
import com.springboot.blog.category.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto getCategory(Long id);
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto);
    String deleteCategory(Long id);
}
