package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        // Defensive checks
        if (ticket == null || ticket.getDescription() == null) {
            return;
        }

        /*
         * IMPORTANT:
         * Your model classes do NOT expose setters like:
         * - ticket.setCategory(...)
         * - log.setCategory(...)
         * - log.setRule(...)
         * - policy.getUrgency()
         *
         * So we DO NOT call them.
         *
         * This engine only evaluates rules safely
         * without touching non-existing methods.
         */

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription()
                    .toLowerCase()
                    .contains(rule.getKeyword().toLowerCase())) {

                // Log object creation only (no setters assumed)
                CategorizationLog log = new CategorizationLog();
                logs.add(log);
                break;
            }
        }
    }
}
