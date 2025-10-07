package com.example.tatacliqreplica.services;

import com.example.tatacliqreplica.models.Categories;
import com.example.tatacliqreplica.models.Products;

import java.util.List;

public interface CategoryService {

    public List<Products> getAllProductsInACategory();

    public List<Categories> getAllCategories();

}
