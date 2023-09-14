package com.springboot.blog.product.presentation.dto.response;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private boolean active;
    private String imageUrl;
}
