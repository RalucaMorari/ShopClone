package com.example.ShopClone.DTOs;

import jakarta.persistence.Column;

public class CategoryResponseDTO {
    @Column
    private String name;
    @Column
    private String description;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
