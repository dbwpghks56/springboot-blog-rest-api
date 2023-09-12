package com.springboot.blog.category.service.impl;

import com.springboot.blog.category.domain.model.Category;
import com.springboot.blog.category.domain.repository.CategoryRepository;
import com.springboot.blog.category.dto.request.CategoryRequestDto;
import com.springboot.blog.category.dto.response.CategoryResponseDto;
import com.springboot.blog.category.exception.CategoryNotFoundException;
import com.springboot.blog.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.save(categoryRequestDto.toEntity());

        return category.toResponseDto();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDto getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id))
                .toResponseDto();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(Category::toResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        category.update(categoryRequestDto);

        return category.toResponseDto();
    }
}
