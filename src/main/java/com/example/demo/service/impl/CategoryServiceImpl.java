package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;

public class CategoryServiceImpl {
    private final CategoryRepository repo;
    public CategoryServiceImpl(CategoryRepository r) { repo = r; }

    public Category createCategory(Category c) { return repo.save(c); }

    public Category getCategory(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}

public class UrgencyPolicyServiceImpl {
    private final UrgencyPolicyRepository repo;
    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository r) { repo = r; }

    public UrgencyPolicy createPolicy(UrgencyPolicy p) { return repo.save(p); }

    public UrgencyPolicy getPolicy(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));
    }
}
