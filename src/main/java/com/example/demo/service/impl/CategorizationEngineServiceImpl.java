package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final CategoryRepository categoryRepository;
    private final UrgencyPolicyRepository urgencyPolicyRepository;
    private final CategorizationLogRepository logRepository;

    public CategorizationEngineServiceImpl(
            CategoryRepository categoryRepository,
            UrgencyPolicyRepository urgencyPolicyRepository,
            CategorizationLogRepository logRepository) {
        this.categoryRepository = categoryRepository;
        this.urgencyPolicyRepository = urgencyPolicyRepository;
        this.logRepository = logRepository;
    }

    @Override
    public CategorizationLog categorizeTicket(Long ticketId) {
        Category category = categoryRepository.findByCategoryName("General")
                .orElseThrow();

        UrgencyPolicy urgency = urgencyPolicyRepository
                .findByKeywordContainingIgnoreCase("default")
                .stream()
                .findFirst()
                .orElseThrow();

        CategorizationLog log = new CategorizationLog(ticketId, category, urgency);
        return logRepository.save(log);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicketId(ticketId);
    }
}
