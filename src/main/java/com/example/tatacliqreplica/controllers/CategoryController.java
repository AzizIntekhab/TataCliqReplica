package com.example.tatacliqreplica.controllers;



import com.example.tatacliqreplica.models.Categories;
import com.example.tatacliqreplica.models.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<Products>> getAllProductsInASingleCategory(@PathVariable("categoryId") Long categoryId) {

        return null;
    }

    @GetMapping()
    public ResponseEntity<List<Categories>> getAllCategories() {

        return null;
    }
}
