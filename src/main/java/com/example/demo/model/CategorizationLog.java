package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Category category;

    @ManyToOne
    private UrgencyPolicy urgencyPolicy;

    public CategorizationLog() {
    }

    /* ---------- GETTERS ---------- */

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Category getCategory() {
        return category;
    }

    public UrgencyPolicy getUrgencyPolicy() {
        return urgencyPolicy;
    }

    /* ---------- SETTERS (REQUIRED BY TEST & ENGINE) ---------- */

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUrgencyPolicy(UrgencyPolicy urgencyPolicy) {
        this.urgencyPolicy = urgencyPolicy;
    }
}
