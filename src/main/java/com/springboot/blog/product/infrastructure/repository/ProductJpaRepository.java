package com.springboot.blog.product.infrastructure.repository;

import com.springboot.blog.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
