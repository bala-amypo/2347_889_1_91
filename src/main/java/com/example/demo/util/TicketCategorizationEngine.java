package com.example.demo.util;

import com.example.demo.model.*;

public class TicketCategorizationEngine {

    public static CategorizationLog categorize(
            Ticket ticket,
            Category category,
            UrgencyPolicy urgencyPolicy
    ) {
        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setCategory(category);
        log.setUrgencyPolicy(urgencyPolicy);
        return log;
    }
}
