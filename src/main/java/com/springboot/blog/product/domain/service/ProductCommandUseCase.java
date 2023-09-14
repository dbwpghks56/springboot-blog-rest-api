package com.springboot.blog.product.domain.service;

import com.springboot.blog.product.presentation.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductCommandUseCase {
    List<ProductResponseDto> searchProducts(String searchString);
}
