package com.springboot.blog.product.presentation.dto.request;

import com.springboot.blog.product.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private String sku;
    private String description;
    private boolean active;
    private String imageUrl;

    public Product toEntity() {
        return Product.builder()
                .name(this.name)
                .sku(this.sku)
                .description(this.description)
                .active(this.active)
                .imageUrl(this.imageUrl)
                .build();
    }
}
