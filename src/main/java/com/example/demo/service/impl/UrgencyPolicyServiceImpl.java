package com.example.demo.service.impl;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;

import org.springframework.stereotype.Service;

@Service
public class UrgencyPolicyServiceImpl {

    private final UrgencyPolicyRepository repository;

    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository repository) {
        this.repository = repository;
    }

    public UrgencyPolicy createPolicy(UrgencyPolicy policy) {
        return repository.save(policy);
    }

    public UrgencyPolicy getPolicy(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
    }
}
