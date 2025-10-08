package com.example.tatacliqreplica.services;

import com.example.tatacliqreplica.dtos.ProductDto;
import com.example.tatacliqreplica.exceptions.ProductNotFoundException;
import com.example.tatacliqreplica.models.Categories;
import com.example.tatacliqreplica.models.Products;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
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


        ProductDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);

        List<Products>  fetchedProductsList = new ArrayList<>();
        for(ProductDto p : products){

            fetchedProductsList.add(convertProductDtoToProduct(p));

        }

        return fetchedProductsList;

    }

    @Override
    public Products getProductById(Long id) throws ProductNotFoundException{

        ProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id, ProductDto.class);
        if(productDto == null){
            throw new ProductNotFoundException("Product with id " +id +" is not present");
        }
        Products fetchedProduct = convertProductDtoToProduct(productDto);
        return fetchedProduct;
    }

    @Override
    public Products addProduct(Products product) {

        ProductDto productDto = convertProductToProductDto(product);

        ProductDto fetchedProduct = restTemplate.postForObject("https://fakestoreapi.com/products", productDto, ProductDto.class);

        return  convertProductDtoToProduct(fetchedProduct);
    }

    @Override
    public ResponseEntity<Products> updateProduct(Long id, Products product) throws ProductNotFoundException {

        ProductDto productDto = convertProductToProductDto(product);
        ProductDto fetchedProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id, ProductDto.class);

        if(productDto.getId() != null) fetchedProductDto.setId(productDto.getId());
        if(productDto.getImage() != null) fetchedProductDto.setImage(productDto.getImage());
        if(productDto.getCategory() != null) fetchedProductDto.setCategory(productDto.getCategory());
        if(productDto.getPrice() != null) fetchedProductDto.setPrice(product.getPrice());
        if(productDto.getDescription() != null) fetchedProductDto.setDescription(product.getDescription());
        if(productDto.getTitle() != null) fetchedProductDto.setTitle(productDto.getTitle());

        restTemplate.put("https://fakestoreapi.com/products/" +id, fetchedProductDto);

        return new ResponseEntity<>(getProductById(id), HttpStatus.OK);
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {

        restTemplate.delete("https://fakestoreapi.com/products/" + id);

        Products product = getProductById(id);
        if(product == null)
            return true;
        else
            return false;
    }

    @Override
    public ResponseEntity<Products> replaceProduct(Long id, Products product) throws ProductNotFoundException {

        ProductDto productDto = convertProductToProductDto(product);
        restTemplate.put("https://fakestoreapi.com/products/" + id, productDto);

        return new ResponseEntity<>(getProductById(id), HttpStatus.OK);
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

    public ProductDto convertProductToProductDto(Products products) {

        ProductDto productDto = new ProductDto();

        productDto.setId(products.getId());
        productDto.setTitle(products.getName());
        productDto.setDescription(products.getDescription());
        productDto.setPrice(products.getPrice());
        productDto.setCategory(products.getCategory().getName());
        productDto.setImage(productDto.getImage());

        return productDto;
    }
}
