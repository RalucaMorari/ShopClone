package com.example.ShopClone.Services;

import com.example.ShopClone.DTOs.ProductResponseDTO;
import com.example.ShopClone.Model.Category;
import com.example.ShopClone.Model.Product;
import com.example.ShopClone.Repositories.CategoryRepository;
import com.example.ShopClone.Repositories.ProductRepository;
import com.example.ShopClone.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Product addProduct(ProductResponseDTO productResponseDTO) {
        Product product = new Product();
        Category category = (Category) this.categoryRepository.findById(productResponseDTO.getCategoryId()).orElseThrow(() -> {
            return new ResourceNotFoundException("category not found");
        });
        product.setName(productResponseDTO.getName());
        product.setDescription(productResponseDTO.getDescription());
        product.setPrice(productResponseDTO.getPrice());
        product.setCategory(category);
        return (Product) this.productRepository.save(product);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product updateProductPrice(Long productId, Double newPrice) {
        Optional<Product> optionalProduct = this.productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = (Product) optionalProduct.get();
            product.setPrice(newPrice);
            return (Product) this.productRepository.save(product);
        } else {
            throw new ResourceNotFoundException("Product with id " + productId + " not found");
        }
    }
}
