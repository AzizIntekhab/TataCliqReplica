package com.example.tatacliqreplica.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Products extends BaseClass{

    private String description;
    @ManyToOne
    private Categories category;
    private Double price;
    private String imageUrl;
}
