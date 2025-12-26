package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class TicketCategorizationEngine {

    public String categorize(String description) {
        if (description == null || description.isEmpty()) {
            return "UNCATEGORIZED";
        }

        if (description.toLowerCase().contains("network")) {
            return "NETWORK";
        } else if (description.toLowerCase().contains("hardware")) {
            return "HARDWARE";
        } else if (description.toLowerCase().contains("software")) {
            return "SOFTWARE";
        }

        return "GENERAL";
    }
}
