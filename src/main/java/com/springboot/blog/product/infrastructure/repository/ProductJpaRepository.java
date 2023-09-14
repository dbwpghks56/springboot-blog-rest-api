package com.springboot.blog.product.infrastructure.repository;

import com.springboot.blog.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE Concat('%', :searchString, '%') OR p.description LIKE Concat('%', :searchString, '%')")
    List<Product> searchProducts(String searchString);
}
