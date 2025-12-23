package com.example.demo.util;

import com.example.demo.model.*;

import java.util.*;
import java.util.regex.Pattern;

public class TicketCategorizationEngine {

    public CategorizationResult categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies
    ) {

        Category selectedCategory = null;
        String urgency = "LOW";
        List<CategorizationLog> logs = new ArrayList<>();

        rules.sort((a, b) -> b.getPriority().compareTo(a.getPriority()));

        for (CategorizationRule rule : rules) {
            if (matches(rule, ticket.getDescription())) {

                selectedCategory = rule.getCategory();
                urgency = selectedCategory.getDefaultUrgency();

                CategorizationLog log = new CategorizationLog(
                        ticket,
                        rule,
                        rule.getKeyword(),
                        selectedCategory.getCategoryName(),
                        urgency
                );
                logs.add(log);
                break;
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription().toLowerCase()
                    .contains(policy.getKeyword().toLowerCase())) {
                urgency = policy.getUrgencyOverride();
            }
        }

        return new CategorizationResult(selectedCategory, urgency, logs);
    }

    private boolean matches(CategorizationRule rule, String text) {
        String keyword = rule.getKeyword();
        String content = text.toLowerCase();

        switch (rule.getMatchType()) {
            case "EXACT":
                return content.equals(keyword.toLowerCase());
            case "CONTAINS":
                return content.contains(keyword.toLowerCase());
            case "REGEX":
                return Pattern.compile(keyword, Pattern.CASE_INSENSITIVE)
                        .matcher(text).find();
            default:
                return false;
        }
    }

    public static class CategorizationResult {
        private final Category category;
        private final String urgency;
        private final List<CategorizationLog> logs;

        public CategorizationResult(Category category, String urgency, List<CategorizationLog> logs) {
            this.category = category;
            this.urgency = urgency;
            this.logs = logs;
        }

        public Category getCategory() {
            return category;
        }

        public String getUrgency() {
            return urgency;
        }

        public List<CategorizationLog> getLogs() {
            return logs;
        }
    }
}
