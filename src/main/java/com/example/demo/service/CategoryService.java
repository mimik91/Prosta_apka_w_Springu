package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    public Category read(Long id) {
        return categoryRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public Category update(Category updatedCategory, Long id) {
        return categoryRepository.findById(id).
                map(entity -> {
                    entity.setName(updatedCategory.getName());
                    return categoryRepository.save(entity);
                }).
                orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public void delete(Long id){
        try {
            categoryRepository.deleteById(id);
        } catch (Exception exception) {
            throw new EntityNotFoundException(Category.class, id);
        }
    }
}