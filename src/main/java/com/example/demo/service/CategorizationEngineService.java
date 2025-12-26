package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import java.util.List;

public interface CategorizationEngineService {

    CategorizationLog categorizeTicket(Long ticketId);

    List<CategorizationLog> getLogsForTicket(Long ticketId);
}
