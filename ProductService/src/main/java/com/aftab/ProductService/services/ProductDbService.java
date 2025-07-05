package com.aftab.ProductService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aftab.ProductService.exceptions.ProductNotFoundException;
import com.aftab.ProductService.models.Category;
import com.aftab.ProductService.models.Product;
import com.aftab.ProductService.repositories.CategoryRepository;
import com.aftab.ProductService.repositories.ProductRepository;

@Service("productDbService")
public class ProductDbService implements ProductService {

    ProductRepository productRepository;

    CategoryRepository categoryRepository;

     public ProductDbService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    // Implement the methods from ProductService interface
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        
        // Logic to retrieve product by ID
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        
        // Logic to retrieve all products
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
      
        // Logic to create a new product
       Category category = getCategoryFromDB(product.getCategory().getName());

                   product.setCategory(category);

        Product createProduct = productRepository.save(product);       
        return createProduct;
    }


      private Category getCategoryFromDB(String categoryName)
    {
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        if(categoryOptional.isPresent())
        {
            return categoryOptional.get();
        }

        Category newCategory = new Category();
        newCategory.setName(categoryName);

        return categoryRepository.save(newCategory);
    }


    @Override
    public Product updateProduct(long id, Product product) throws ProductNotFoundException {
       
        // Logic to update an existing product
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(getCategoryFromDB(product.getCategory().getName()));
            return productRepository.save(existingProduct);
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }
    
}
