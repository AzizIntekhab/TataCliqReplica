package com.example.tatacliqreplica.models;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Products {

    private Long id;
    private String name;
    private String description;
    private Category category;
    private Double price;
    private String imageUrl;
}
