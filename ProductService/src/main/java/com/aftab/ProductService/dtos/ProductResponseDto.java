package com.aftab.ProductService.dtos;

import com.aftab.ProductService.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private long categoryId;

    public ProductResponseDto(long id, String name, String description, double price, String imageUrl, long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

   public static  ProductResponseDto from(Product product) {
        return new ProductResponseDto(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getImageUrl(),
            product.getCategory() != null ? product.getCategory().getId() : 0
        );
    }

    
}
