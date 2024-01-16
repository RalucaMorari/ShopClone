package com.example.ShopClone.DTOs;

import jakarta.persistence.Column;

public class ProductResponseDTO {
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String description;
    @Column
    private Long categoryId;
    @Column
    private Long productId;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String name, Double price, String description, Long categoryId, Long productId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.productId = productId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
