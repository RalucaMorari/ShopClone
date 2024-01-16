package com.example.ShopClone.Services;

import com.example.ShopClone.DTOs.CategoryResponseDTO;
import com.example.ShopClone.Model.Category;
import com.example.ShopClone.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryResponseDTO categoryResponseDTO) {
        Category category = new Category();
        category.setName(categoryResponseDTO.getName());
        category.setDescription(categoryResponseDTO.getDescription());
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

}
