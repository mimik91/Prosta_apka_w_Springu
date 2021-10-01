package com.example.demo.api;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductREST {
    private final ProductService productService;

    public ProductREST(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    List<Product> all() {
        return productService.readAll();
    }

    @PostMapping("/api/products")
    Product newEntity(@RequestBody Product newEntity) {
        return productService.create(newEntity);
    }

    @GetMapping("/api/products/{id}")
    Product one(@PathVariable Long id) {
        return productService.read(id);
    }

    @PutMapping("/api/products/{id}")
    Product replaceEntity(@RequestBody Product newEntity, @PathVariable Long id) {
        return productService.update(newEntity, id);
    }

    @DeleteMapping("/api/products/{id}")
    void deleteEntity(@PathVariable Long id) {
        productService.delete(id);
    }
}
