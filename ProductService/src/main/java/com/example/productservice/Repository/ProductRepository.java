package com.example.productservice.Repository;

import com.example.productservice.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    @Query("FROM ProductEntity product WHERE product.product_name=:product")
      ArrayList<ProductEntity> getRelatedProduct(@Param("product") String product);
}
