package com.example.demo.service.impl;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import org.springframework.stereotype.Service;

@Service
public class UrgencyPolicyServiceImpl {

    private final UrgencyPolicyRepository repo;

    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository repo) {
        this.repo = repo;
    }

    public UrgencyPolicy save(UrgencyPolicy p) {
        return repo.save(p);
    }
}
