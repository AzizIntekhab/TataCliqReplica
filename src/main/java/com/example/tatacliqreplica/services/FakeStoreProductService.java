package com.example.tatacliqreplica.services;

import com.example.tatacliqreplica.dtos.ProductDto;
import com.example.tatacliqreplica.models.Categories;
import com.example.tatacliqreplica.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    @Autowired
    RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Products> getProducts() {
        return List.of();
    }

    @Override
    public Products getProductById(Long id) {

        ProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id, ProductDto.class);
        Products fetchedProduct = convertProductDtoToProduct(productDto);
        return fetchedProduct;
    }

    @Override
    public Products addProduct(Products product) {
        return null;
    }

    @Override
    public Products updateProduct(Products product) {
        return null;
    }

    @Override
    public Products deleteProduct(Long id) {
        return null;
    }

    @Override
    public Products replaceProduct(Products product) {
        return null;
    }

    public Products convertProductDtoToProduct(ProductDto productDto) {

        Products products = new Products();

        products.setId(productDto.getId());
        products.setName(productDto.getTitle());
        products.setDescription(productDto.getDescription());

        Categories category = new Categories();
        category.setName(productDto.getCategory());
        products.setCategory(category);
        products.setImageUrl(productDto.getImage());

        return products;
    }
}
