package com.example.demo.repository;

import com.example.demo.model.UrgencyPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UrgencyPolicyRepository extends JpaRepository<UrgencyPolicy, Long> {

    Optional<UrgencyPolicy> findById(Long id);

    List<UrgencyPolicy> findAll();

    List<UrgencyPolicy> findByKeywordContainingIgnoreCase(String keyword);
}
