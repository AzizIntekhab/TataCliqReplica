package com.example.tatacliqreplica.repositories;

import com.example.tatacliqreplica.models.Categories;
import com.example.tatacliqreplica.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
