package com.example.orderservice.Repository;

import com.example.orderservice.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT order FROM OrderEntity order WHERE order.productName = :productName")
    List<OrderEntity> findByProductName(@Param("productName") String productName);
}
