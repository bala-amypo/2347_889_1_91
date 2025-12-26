package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

@Service
public class CategorizationEngineServiceImpl
        implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository urgencyPolicyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository urgencyPolicyRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.urgencyPolicyRepository = urgencyPolicyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }
}
