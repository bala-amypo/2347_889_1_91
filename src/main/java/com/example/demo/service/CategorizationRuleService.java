package com.example.demo.service;

import com.example.demo.model.CategorizationRule;

import java.util.List;

public interface CategorizationRuleService {

    CategorizationRule createRule(Long categoryId, CategorizationRule rule);

    CategorizationRule getRule(Long id);

    List<CategorizationRule> getRulesByCategory(Long categoryId);
}
