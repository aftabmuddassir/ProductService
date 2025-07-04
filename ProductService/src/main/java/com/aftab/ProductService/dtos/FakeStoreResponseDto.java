package com.aftab.ProductService.dtos;



import com.aftab.ProductService.models.Category;
import com.aftab.ProductService.models.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;


    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        Category cat = new Category();
        cat.setName(this.category);
        product.setCategory(cat);
        product.setImageUrl(this.image);
        return product;
    }


   
}