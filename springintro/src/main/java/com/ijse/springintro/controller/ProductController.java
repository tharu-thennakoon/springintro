package com.ijse.springintro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ijse.springintro.Entity.Product;
import com.ijse.springintro.Entity.Category;
import com.ijse.springintro.dto.ProductReqDTO;
import com.ijse.springintro.service.CategoryService;
import com.ijse.springintro.service.ProductService;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductReqDTO productReqDTO) {
        Product product = new Product();
        product.setName(productReqDTO.getName());
        product.setPrice(productReqDTO.getPrice());
        product.setDescription(productReqDTO.getDescription());
        
        // Find category by categoryId id in productReqDTO and assign it to new Product.
        Category category = categoryService.getCategoryById(productReqDTO.getCategoryId());
        product.setCategory(category);

        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @PutMapping("/products/${productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, ProductReqDTO productReqDTO){
        Product product = new Product();
        product.setName(productReqDTO.getName());
        product.setPrice(productReqDTO.getPrice());
        product.setDescription(productReqDTO.getDescription());
        
        // Find category by categoryId id in productReqDTO and assign it to new Product.
        Category category = categoryService.getCategoryById(productReqDTO.getCategoryId());
        product.setCategory(category);

        Product updatedProduct = productService.updateProduct(productId, product);
        return ResponseEntity.status(200).body(updatedProduct);

    }

}
