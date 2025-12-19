package com.example.demo.util;

import com.example.demo.model.Ticket;

public class TicketCategorizationEngine {

    public String categorize(Ticket ticket) {

        if (ticket.getDescription().toLowerCase().contains("login")) {
            return "AUTH";
        }

        if (ticket.getDescription().toLowerCase().contains("payment")) {
            return "BILLING";
        }

        return "GENERAL";
    }
}
