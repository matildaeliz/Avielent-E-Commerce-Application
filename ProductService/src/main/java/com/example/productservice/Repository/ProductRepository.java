package com.example.productservice.Repository;

import com.example.productservice.Entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    @Query("FROM ProductEntity product WHERE product.product_name=:product")
      ArrayList<ProductEntity> getRelatedProduct(@Param("product") String product);

    @Query("SELECT product.product_star FROM ProductEntity product WHERE product.id=:id ")
    double getStarbyid(@Param("id") int id);
    @Query("SELECT product.product_starcount FROM ProductEntity product WHERE product.id=:id ")
    int getStarCountbyid(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity product SET  product.product_starcount = product.product_starcount+1 WHERE product.id=:id")
     void updateCountbyid(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity product SET product.product_star = :newstar WHERE product.id = :id")
    void updateStarbyid(@Param("id") int id, @Param("newstar") double newstar);
}
