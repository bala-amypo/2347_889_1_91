package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService service;

    public CategorizationRuleController(CategorizationRuleService service) {
        this.service = service;
    }

    @PostMapping("/category/{categoryId}")
    public CategorizationRule create(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {

        return service.createRule(categoryId, rule);
    }

    @GetMapping("/{id}")
    public CategorizationRule get(@PathVariable Long id) {
        return service.getRule(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getByCategory(
            @PathVariable Long categoryId) {

        return service.getRulesByCategory(categoryId);
    }
}
