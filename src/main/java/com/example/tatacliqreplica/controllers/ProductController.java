package com.example.tatacliqreplica.controllers;

import com.example.tatacliqreplica.exceptions.ProductNotFoundException;
import com.example.tatacliqreplica.models.Products;
import com.example.tatacliqreplica.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }


    @GetMapping("")
    public ResponseEntity<List<Products>> getAllProducts() {

        List<Products> productsArrayList = productService.getProducts();
        return new ResponseEntity<>(productsArrayList, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Products> getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {

        Products product = productService.getProductById(productId);
        return new  ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Products> addANewProduct(@RequestBody Products newProduct) {

        Products product = productService.addProduct(newProduct);


        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteAProduct(@PathVariable("productId") Long productId) {

        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product with " +productId +" is deleted.",HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> replaceAProduct(@PathVariable("productId") Long productId, @RequestBody Products newProduct) {

        productService.replaceProduct(productId, newProduct);
        return new ResponseEntity<>("Product with " +productId +" is replaced.",HttpStatus.OK);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<String> updateAProduct(@PathVariable("productId")  Long productId, @RequestBody Products newProduct) {

        productService.updateProduct(productId, newProduct);
        return new ResponseEntity<>("Product with " +productId +" is updated.",HttpStatus.OK);

    }
}
