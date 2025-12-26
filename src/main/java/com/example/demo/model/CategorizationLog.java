package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private CategorizationRule appliedRule;

    public CategorizationLog() {
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
 
    public Ticket getTicket() {
        return ticket;
    }
 
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
 
    public CategorizationRule getAppliedRule() {
        return appliedRule;
    }
 
    public void setAppliedRule(CategorizationRule appliedRule) {
        this.appliedRule = appliedRule;
    }
}
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private CategorizationRule appliedRule;

    public CategorizationLog() {
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
 
    public Ticket getTicket() {
        return ticket;
    }
 
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
 
    public CategorizationRule getAppliedRule() {
        return appliedRule;
    }
 
    public void setAppliedRule(CategorizationRule appliedRule) {
        this.appliedRule = appliedRule;
    }
}
