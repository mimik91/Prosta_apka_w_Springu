package com.example.demo.repository;

import com.example.demo.model.ProductBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBasketRepository extends JpaRepository<ProductBasket, Long> {
}
