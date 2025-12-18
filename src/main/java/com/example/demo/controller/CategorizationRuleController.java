package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    @Autowired
    private CategorizationRuleRepository ruleRepository;

    @PostMapping
    public CategorizationRule createRule(@RequestBody CategorizationRule rule) {
        return ruleRepository.save(rule);
    }

    @GetMapping
    public List<CategorizationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
