package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> readAll() {
        return tagRepository.findAll();
    }

    public Tag create(Tag newTag) {
        return tagRepository.save(newTag);
    }

    public Tag read(Long id) {
        return tagRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public Tag update(Tag updatedTag, Long id) {
        return tagRepository.findById(id).
                map(entity -> {
                    entity.setName(updatedTag.getName());
                    entity.setProducts(updatedTag.getProducts());
                    return tagRepository.save(entity);
                }).
                orElseThrow(() -> new EntityNotFoundException(Category.class, id));
    }

    public void delete(Long id){
        try {
            tagRepository.deleteById(id);
        } catch (Exception exception) {
            throw new EntityNotFoundException(Tag.class, id);
        }
    }
}
