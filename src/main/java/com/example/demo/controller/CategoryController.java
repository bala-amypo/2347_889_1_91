package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServiceImpl service;

    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return service.getCategory(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }
}
