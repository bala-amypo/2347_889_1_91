package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository repo;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository repo) {
        this.repo = repo;
    }

    public List<CategorizationRule> getAll() {
        return repo.findAll(); 
    }
}
