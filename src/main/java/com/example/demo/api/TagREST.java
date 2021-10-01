package com.example.demo.api;

import com.example.demo.model.Tag;
import com.example.demo.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagREST {
    private final TagService tagService;

    public TagREST(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/api/tags")
    List<Tag> all() {
        return tagService.readAll();
    }

    @PostMapping("/api/tags")
    Tag newEntity(@RequestBody Tag newEntity) {
        return tagService.create(newEntity);
    }

    @GetMapping("/api/tags/{id}")
    Tag one(@PathVariable Long id) {
        return tagService.read(id);
    }

    @PutMapping("/api/tags/{id}")
    Tag replaceEntity(@RequestBody Tag newEntity, @PathVariable Long id) {
        return tagService.update(newEntity, id);
    }

    @DeleteMapping("/api/tags/{id}")
    void deleteEntity(@PathVariable Long id) {
        tagService.delete(id);
    }
}
