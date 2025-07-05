package com.aftab.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base {

    
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category category;

    
}
