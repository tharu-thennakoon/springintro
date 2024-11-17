package com.ijse.springintro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springintro.Entity.Category;
import com.ijse.springintro.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.getAllCategories(); 
        return ResponseEntity.status(200).body(categories);
        
    }
    
}
