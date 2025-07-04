package com.aftab.ProductService.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aftab.ProductService.exceptions.ProductNotFoundException;
import com.aftab.ProductService.dtos.CreateFakeProductRequestDto;
import com.aftab.ProductService.dtos.ProductResponseDto;
import com.aftab.ProductService.models.Product;
import com.aftab.ProductService.services.ProductService;

@RestController
public class ProductController {

    
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("products/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") long id)  throws ProductNotFoundException {

        Product product = productService.getProductById(id);
        return ProductResponseDto.from(product);
    }

    @GetMapping("products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return  products.stream()
                .map(ProductResponseDto::from)
                .toList();
    }

    @PostMapping("products")
    public ProductResponseDto createProduct(CreateFakeProductRequestDto productRequestDto) {


        Product createdProduct = productService.createProduct(productRequestDto.toProduct());
        if (createdProduct != null) {
            return ProductResponseDto.from(createdProduct);
        }
        return null; // Placeholder return statement
    }

    @PutMapping("products/{id}")
    public ProductResponseDto updateProduct(@PathVariable("id") long id, CreateFakeProductRequestDto productRequestDto) throws ProductNotFoundException {
        Product updatedProduct = productService.updateProduct(id, productRequestDto.toProduct());
        return ProductResponseDto.from(updatedProduct);
    }

    
}
