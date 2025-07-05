package com.aftab.ProductService.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aftab.ProductService.models.Product;

public interface ProductRepository extends JpaRepository<Product , Long> {
    // Additional query methods can be defined here if needed

    //save
    Product save(Product product);

    Optional<Product> findById(long id);

    List<Product> findAll();
    
}
