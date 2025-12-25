package com.example.demo.util;

import com.example.demo.model.*;
import java.util.*;

public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs) {

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription().toLowerCase()
                    .contains(rule.getKeyword().toLowerCase())) {

                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                logs.add(log);
                break;
            }
        }

        for (UrgencyPolicy p : policies) {
            if (ticket.getDescription().toLowerCase()
                    .contains(p.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(p.getUrgencyOverride());
            }
        }

        if (ticket.getUrgencyLevel() == null)
            ticket.setUrgencyLevel("LOW");
    }
}
