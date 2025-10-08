package com.example.tatacliqreplica.services;

import com.example.tatacliqreplica.exceptions.ProductNotFoundException;
import com.example.tatacliqreplica.models.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public List<Products> getProducts();

    public Products getProductById(Long id) throws ProductNotFoundException;

    public Products addProduct(Products product);

    public ResponseEntity<Products> updateProduct(Long id, Products product) throws ProductNotFoundException;

    public boolean deleteProduct(Long id) throws ProductNotFoundException;

    public ResponseEntity<Products> replaceProduct(Long id, Products product) throws ProductNotFoundException;
}
