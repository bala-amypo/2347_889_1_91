package com.example.demo.service;

import com.example.demo.model.Category;
import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();
}
