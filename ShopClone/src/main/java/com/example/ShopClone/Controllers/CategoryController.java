package com.example.ShopClone.Controllers;

import com.example.ShopClone.DTOs.CategoryResponseDTO;
import com.example.ShopClone.Model.Category;
import com.example.ShopClone.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryResponseDTO categoryResponseDTO) {
        Category newCategory = categoryService.createCategory(categoryResponseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>>findAll(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }
}
