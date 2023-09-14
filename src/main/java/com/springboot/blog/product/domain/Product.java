package com.springboot.blog.product.domain;

import com.springboot.blog.boot.domain.model.BaseEntity;
import com.springboot.blog.product.presentation.dto.response.ProductResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sku;
    private String description;
    private boolean active;
    private String imageUrl;

    public ProductResponseDto toResponseDto() {
        return ProductResponseDto.builder()
                .id(this.id)
                .name(this.name)
                .sku(this.sku)
                .description(this.description)
                .active(this.active)
                .imageUrl(this.imageUrl)
                .build();
    }
}








