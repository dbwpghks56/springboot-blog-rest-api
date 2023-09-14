package com.springboot.blog.product.presentation;

import com.springboot.blog.product.application.ProductFacade;
import com.springboot.blog.product.presentation.dto.request.ProductRequestDto;
import com.springboot.blog.product.presentation.dto.response.ProductResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductRestController {
    private final ProductFacade productFacade;

    @GetMapping("/{searchString}")
    public ResponseEntity<List<ProductResponseDto>> searchProducts(@PathVariable String searchString) {
        return ResponseEntity.ok(productFacade.searchProducts(searchString));
    }

    @PostMapping
    @SecurityRequirement(name = "Bear Authentication")
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.ok(productFacade.saveProduct(productRequestDto));
    }
}
