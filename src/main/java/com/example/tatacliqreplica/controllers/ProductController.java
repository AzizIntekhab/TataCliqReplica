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
    public ResponseEntity<String> deleteAProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {

        boolean ans = productService.deleteProduct(productId);
        if(ans == true)
            return new ResponseEntity<>("Product with " +productId +" is deleted.",HttpStatus.OK);
        else
            return new ResponseEntity<>("Product with " +productId +" is not deleted.",HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Products> replaceAProduct(@PathVariable("productId") Long productId, @RequestBody Products newProduct) throws ProductNotFoundException {

        ResponseEntity<Products> responseEntity = productService.replaceProduct(productId, newProduct);
        return responseEntity;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Products> updateAProduct(@PathVariable("productId")  Long productId, @RequestBody Products newProduct) throws ProductNotFoundException {

        ResponseEntity<Products> resposeEntity = productService.updateProduct(productId, newProduct);
        return resposeEntity;

    }
}
