package com.example.demo.service.impl;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Category;
import com.example.demo.model.Ticket;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.repository.TicketRepository;
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

    @Override
    public CategorizationLog categorizeTicket(Ticket ticket, Category category, UrgencyPolicy urgencyPolicy) {
        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setCategory(category);
        log.setUrgencyPolicy(urgencyPolicy);
        return logRepository.save(log);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        // Fetch ticket first (optional, depending on your repository)
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + ticketId));

        // Return all logs for this ticket
        return logRepository.findByTicket(ticket);
    }
}
