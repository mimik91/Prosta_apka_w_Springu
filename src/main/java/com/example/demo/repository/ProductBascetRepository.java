package com.example.demo.repository;

import com.example.demo.model.ProductBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBascetRepository extends JpaRepository<ProductBasket, Long> {
}
