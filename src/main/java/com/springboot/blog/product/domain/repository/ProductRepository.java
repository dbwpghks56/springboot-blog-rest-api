package com.springboot.blog.product.domain.repository;

import com.springboot.blog.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> searchProducts(String searchString);
    Product saveProduct(Product product);
    Optional<Product> findById(Long id);
}
