package com.example.tatacliqreplica.controllers;

import com.example.tatacliqreplica.models.Products;
import com.example.tatacliqreplica.services.FakeStoreProductService;
import com.example.tatacliqreplica.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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


    @GetMapping()
    public ResponseEntity<List<Products>> getAllProducts() {

        return null;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Products> getProductById(@PathVariable("productId") Long productId) {

        Products product = productService.getProductById(productId);
        return new  ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Products> addANewProduct(@RequestBody Products newProduct) {

        return null;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Products> deleteAProduct(@PathVariable("productId") Long productId) {

        return null;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Products> replaceAProduct(@PathVariable("productId") Long productId, @RequestBody Products newProduct) {

        return null;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Products> updateAProduct(@PathVariable("productId")  Long productId, @RequestBody Products newProduct) {

        return null;
    }
}
