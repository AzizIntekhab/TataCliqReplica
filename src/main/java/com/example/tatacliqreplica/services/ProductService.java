package com.example.tatacliqreplica.services;

import com.example.tatacliqreplica.exceptions.ProductNotFoundException;
import com.example.tatacliqreplica.models.Products;

import java.util.List;

public interface ProductService {

    public List<Products> getProducts();

    public Products getProductById(Long id) throws ProductNotFoundException;

    public Products addProduct(Products product);

    public void updateProduct(Long id, Products product);

    public void deleteProduct(Long id);

    public void replaceProduct(Long id, Products product);
}
