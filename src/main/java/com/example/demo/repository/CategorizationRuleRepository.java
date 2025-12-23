package com.example.demo.repository;

import com.example.demo.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {

    List<CategorizationRule> findByCategoryId(Long categoryId);

    Optional<CategorizationRule> findById(Long id);

    List<CategorizationRule> findAll();

    List<CategorizationRule> findByKeywordContainingIgnoreCase(String keyword);
}
