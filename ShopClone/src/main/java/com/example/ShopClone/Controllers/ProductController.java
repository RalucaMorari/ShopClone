package com.example.ShopClone.Controllers;

import com.example.ShopClone.DTOs.ProductResponseDTO;
import com.example.ShopClone.Model.Product;
import com.example.ShopClone.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct (@RequestBody ProductResponseDTO productResponseDTO) {
        Product product = productService.addProduct(productResponseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<Product>>findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{productId}/updatePrice")
    public ResponseEntity<Product> updateProductPrice(
            @PathVariable Long productId,
            @RequestParam Double newPrice) {
        Product updatedProduct = productService.updateProductPrice(productId, newPrice);
        return ResponseEntity.ok(updatedProduct);
    }



}
