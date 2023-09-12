package com.springboot.blog.category.web;

import com.springboot.blog.category.dto.request.CategoryRequestDto;
import com.springboot.blog.category.dto.response.CategoryResponseDto;
import com.springboot.blog.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/category")
@Slf4j
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CategoryResponseDto> addCategory(
            @RequestBody CategoryRequestDto categoryRequestDto) {
        return new ResponseEntity<>(categoryService.addCategory(categoryRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequestDto));
    }
}
