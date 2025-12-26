package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketCategorizationEngine {

    // ❗❗ THIS IS THE ONLY categorize METHOD
    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        if (ticket == null || ticket.getDescription() == null) {
            return;
        }

        // Apply categorization rules
        for (CategorizationRule rule : rules) {
            if (ticket.getDescription()
                    .toLowerCase()
                    .contains(rule.getKeyword().toLowerCase())) {

                ticket.setCategory(rule.getCategory());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setCategory(rule.getCategory());
                log.setRule(rule);

                logs.add(log);
                break;
            }
        }

        // Apply urgency policies
        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription()
                    .toLowerCase()
                    .contains(policy.getKeyword().toLowerCase())) {

                ticket.setUrgency(policy.getUrgency());
                break;
            }
        }
    }
}
