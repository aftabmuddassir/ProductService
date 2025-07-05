package com.aftab.ProductService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aftab.ProductService.models.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
   

    // Placeholder for save method, JpaRepository already provides this functionality
    public Category save(Category category);

    public Optional<Category> findByName(String name);
    
}
