package com.example.tatacliqreplica.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;
}
