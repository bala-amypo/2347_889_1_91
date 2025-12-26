package com.example.demo.util;

import com.example.demo.model.*;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TicketCategorizationEngine {

    public CategorizationLog categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> urgencyPolicies
    ) {
        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setCategory(categories.get(0));
        log.setUrgencyPolicy(urgencyPolicies.get(0));
        return log;
    }
}
