package com.aftab.ProductService.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category  extends Base {

    @OneToMany(mappedBy = "category")
    List  <Product> products;
 
    
}
