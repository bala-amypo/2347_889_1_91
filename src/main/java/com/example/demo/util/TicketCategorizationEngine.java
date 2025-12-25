package com.example.demo.util;

import com.example.demo.model.*;

import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public CategorizationResult categorize(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies) {

        CategorizationRule matchedRule = rules.stream()
                .filter(r -> ticket.getDescription()
                        .toLowerCase()
                        .contains(r.getKeyword().toLowerCase()))
                .sorted(Comparator.comparing(CategorizationRule::getPriority))
                .findFirst()
                .orElse(null);

        String categoryName = matchedRule != null
                ? matchedRule.getCategory().getCategoryName()
                : "Uncategorized";

        String urgency = matchedRule != null
                ? matchedRule.getCategory().getDefaultUrgency()
                : ticket.getUrgencyLevel();

        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription()
                    .toLowerCase()
                    .contains(policy.getKeyword().toLowerCase())) {
                urgency = policy.getUrgencyOverride();
                break;
            }
        }

        return new CategorizationResult(
                matchedRule,
                categoryName,
                urgency
        );
    }

    // Inner helper DTO
    public static class CategorizationResult {
        private final CategorizationRule rule;
        private final String category;
        private final String urgency;

        public CategorizationResult(CategorizationRule rule,
                                    String category,
                                    String urgency) {
            this.rule = rule;
            this.category = category;
            this.urgency = urgency;
        }

        public CategorizationRule getRule() { return rule; }
        public String getCategory() { return category; }
        public String getUrgency() { return urgency; }
    }
}
`