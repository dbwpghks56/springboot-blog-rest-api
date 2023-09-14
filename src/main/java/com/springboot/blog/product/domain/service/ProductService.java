package com.springboot.blog.product.domain.service;

import com.springboot.blog.product.domain.Product;
import com.springboot.blog.product.domain.repository.ProductRepository;
import com.springboot.blog.product.presentation.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService implements ProductCommandUseCase{
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDto> searchProducts(String searchString) {
        return productRepository.searchProducts(searchString).stream().map(Product::toResponseDto).toList();
    }
}
