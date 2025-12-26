package com.example.demo.service.impl;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Category;
import com.example.demo.model.Ticket;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    @Autowired
    private CategorizationLogRepository logRepository;

    @Override
    public CategorizationLog categorizeTicket(Ticket ticket, Category category, UrgencyPolicy urgencyPolicy) {
        // Create log using no-arg constructor
        CategorizationLog log = new CategorizationLog();
        
        // Set the fields
        log.setTicket(ticket);
        log.setCategory(category);
        log.setUrgencyPolicy(urgencyPolicy);
        
        // Save log to database
        return logRepository.save(log);
    }
}
