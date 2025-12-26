package com.example.demo.repository;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorizationLogRepository extends JpaRepository<CategorizationLog, Long> {

    // Fetch all logs for a ticket
    List<CategorizationLog> findByTicket(Ticket ticket);
}
