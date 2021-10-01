package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.ProductBasket;
import com.example.demo.repository.ProductBasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBasketService {
    private final ProductBasketRepository productBasketRepository;

    public ProductBasketService(ProductBasketRepository productBasketRepository) {
        this.productBasketRepository = productBasketRepository;
    }

    public List<ProductBasket> readAll() {
        return productBasketRepository.findAll();
    }

    public ProductBasket create(ProductBasket newProductBasket) {
        return productBasketRepository.save(newProductBasket);
    }

    public ProductBasket read(Long id) {
        return productBasketRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(ProductBasket.class, id));
    }

    public ProductBasket update(ProductBasket updatedProductBasket, Long id) {
        return productBasketRepository.findById(id).
                map(entity -> {
                    entity.setAmount(updatedProductBasket.getAmount());
                    entity.setProduct(updatedProductBasket.getProduct());
                    entity.setOrder(updatedProductBasket.getOrder());
                    return productBasketRepository.save(entity);
                }).
                orElseThrow(() -> new EntityNotFoundException(ProductBasket.class, id));
    }

    public void delete(Long id) {
        try {
            productBasketRepository.deleteById(id);
        } catch (Exception exception) {
            throw new EntityNotFoundException(ProductBasket.class, id);
        }
    }
}