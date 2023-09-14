package com.springboot.blog.product.presentation;

import com.springboot.blog.product.application.ProductFacade;
import com.springboot.blog.product.presentation.dto.response.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductRestController {
    private final ProductFacade productFacade;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> searchProducts(String searchString) {
        return ResponseEntity.ok(productFacade.searchProducts(searchString));
    }
}
