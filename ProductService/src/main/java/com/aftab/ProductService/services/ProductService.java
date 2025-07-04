package com.aftab.ProductService.services;

import java.util.List;

import com.aftab.ProductService.exceptions.ProductNotFoundException;
import com.aftab.ProductService.models.Product;

public interface ProductService {
    
    Product getProductById(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product); // Placeholder for product creation method

    Product updateProduct(long id, Product product) throws ProductNotFoundException; // Placeholder for product update method
}
