package com.example.tatacliqreplica.services;

import com.example.tatacliqreplica.models.Products;

import java.util.List;

public interface ProductService {

    public List<Products> getProducts();

    public Products getProductById(Long id);

    public Products addProduct(Products product);

    public Products updateProduct(Products product);

    public Products deleteProduct(Long id);

    public Products replaceProduct(Products product);
}
