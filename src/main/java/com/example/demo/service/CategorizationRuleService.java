package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CategorizationRule;

public interface CategorizationRuleService {

    CategorizationRule createRule(CategorizationRule rule);

    List<CategorizationRule> getAllRules();

    CategorizationRule getRule(Long id);
}
