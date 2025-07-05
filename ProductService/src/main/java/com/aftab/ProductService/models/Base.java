package com.aftab.ProductService.models;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;

    
    @PrePersist
    public void onCreate() {
        this.createdAt = Date.valueOf(LocalDate.now());
        this.updatedAt = Date.valueOf(LocalDate.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Date.valueOf(LocalDate.now());
    }
    
    
}
