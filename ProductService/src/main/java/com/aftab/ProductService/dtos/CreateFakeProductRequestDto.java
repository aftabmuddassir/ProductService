package com.aftab.ProductService.dtos;


import com.aftab.ProductService.models.Category;
import com.aftab.ProductService.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFakeProductRequestDto {

    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;

    public CreateFakeProductRequestDto() {
        // Default constructor
    }

    public CreateFakeProductRequestDto(String name, String description, double price, String imageUrl, String category) {
        this.title = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Product toProduct() {//do this ideally in service layer
        Product product = new Product();
        product.setName(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        
        Category category = new Category();
        category.setName(this.category);

        product.setCategory(category);
        
        return product;
    }


    
}
