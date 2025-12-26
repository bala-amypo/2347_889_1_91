package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private UrgencyPolicy urgencyPolicy;

    @ManyToOne
    private Ticket ticket;  // Add this field

    // No-arg constructor (required by JPA)
    public CategorizationLog() {}

    // Constructor with fields (optional)
    public CategorizationLog(Long id, Category category, UrgencyPolicy urgencyPolicy, Ticket ticket) {
        this.id = id;
        this.category = category;
        this.urgencyPolicy = urgencyPolicy;
        this.ticket = ticket;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public UrgencyPolicy getUrgencyPolicy() { return urgencyPolicy; }
    public void setUrgencyPolicy(UrgencyPolicy urgencyPolicy) { this.urgencyPolicy = urgencyPolicy; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
}
