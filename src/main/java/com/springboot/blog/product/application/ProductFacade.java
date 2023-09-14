package com.springboot.blog.product.application;

import com.springboot.blog.product.domain.service.ProductCommandUseCase;
import com.springboot.blog.product.presentation.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFacade {
    private final ProductCommandUseCase productCommandUseCase;

    public List<ProductResponseDto> searchProducts(String searchString) {
        return productCommandUseCase.searchProducts(searchString);
    }
}
