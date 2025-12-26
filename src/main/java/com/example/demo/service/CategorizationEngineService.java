package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Category;
import com.example.demo.model.Ticket;
import com.example.demo.model.UrgencyPolicy;

import java.util.List;

public interface CategorizationEngineService {

    // Categorize a ticket
    CategorizationLog categorizeTicket(Long ticketId, Long categoryId, Long urgencyPolicyId);

    // Get all logs for a ticket
    List<CategorizationLog> getLogsForTicket(Long ticketId);
}
