package com.example.demo.service.impl;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Category;
import com.example.demo.model.Ticket;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UrgencyPolicyRepository;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    @Autowired
    private CategorizationLogRepository logRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UrgencyPolicyRepository urgencyPolicyRepository;

    // Implement categorizeTicket
    @Override
    public CategorizationLog categorizeTicket(Long ticketId, Long categoryId, Long urgencyPolicyId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + ticketId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));

        UrgencyPolicy urgencyPolicy = urgencyPolicyRepository.findById(urgencyPolicyId)
                .orElseThrow(() -> new RuntimeException("UrgencyPolicy not found with id " + urgencyPolicyId));

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setCategory(category);
        log.setUrgencyPolicy(urgencyPolicy);

        return logRepository.save(log);
    }

    // Implement getLogsForTicket
    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + ticketId));

        return logRepository.findByTicket(ticket);
    }
}
