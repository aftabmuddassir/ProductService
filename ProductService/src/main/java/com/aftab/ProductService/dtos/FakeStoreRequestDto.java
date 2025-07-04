package com.aftab.ProductService.dtos;

import com.aftab.ProductService.models.Category;
import com.aftab.ProductService.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreRequestDto {
    
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private long categoryId;

    public FakeStoreRequestDto() {
        // Default constructor
    }

    public FakeStoreRequestDto(String name, String description, double price, String imageUrl, long categoryId) {
        this.title = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public  FakeStoreRequestDto(Product product) {
        FakeStoreRequestDto dto = new FakeStoreRequestDto();
        dto.setTitle(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImageUrl());
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
        }

    }


}
