package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "urgency_policy_id")
    private UrgencyPolicy urgencyPolicy;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    // No-arg constructor (required by JPA)
    public CategorizationLog() {}

    // All-args constructor
    public CategorizationLog(Long id, Category category, UrgencyPolicy urgencyPolicy, Ticket ticket) {
        this.id = id;
        this.category = category;
        this.urgencyPolicy = urgencyPolicy;
        this.ticket = ticket;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UrgencyPolicy getUrgencyPolicy() {
        return urgencyPolicy;
    }

    public void setUrgencyPolicy(UrgencyPolicy urgencyPolicy) {
        this.urgencyPolicy = urgencyPolicy;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
