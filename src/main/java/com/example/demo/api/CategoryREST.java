package com.example.demo.api;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryREST {
    private final CategoryService categoryService;

    public CategoryREST(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    List<Category> all() {
        return categoryService.readAll();
    }

    @PostMapping("/api/categories")
    Category newEntity(@RequestBody Category newEntity) {
        return categoryService.create(newEntity);
    }

    @GetMapping("/api/categories/{id}")
    Category one(@PathVariable Long id) {
        return categoryService.read(id);
    }

    @PutMapping("/api/categories/{id}")
    Category replaceEntity(@RequestBody Category newEntity, @PathVariable Long id) {
        return categoryService.update(newEntity, id);
    }

    @DeleteMapping("/api/categories/{id}")
    void deleteEntity(@PathVariable Long id) {
        categoryService.delete(id);
    }
}