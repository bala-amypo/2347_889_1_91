package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;

public interface CategorizationEngineService {

    Ticket categorizeTicket(Long ticketId);

    List<CategorizationLog> getAllLogs();

    CategorizationLog getLog(Long id);

    List<CategorizationLog> getLogsForTicket(Long ticketId);
}
