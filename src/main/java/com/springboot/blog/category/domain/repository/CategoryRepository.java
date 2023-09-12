package com.springboot.blog.category.domain.repository;

import com.springboot.blog.category.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
