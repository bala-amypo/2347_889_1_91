package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    private Ticket ticket;

    public CategorizationLog() {}

    public CategorizationLog(String message, Ticket ticket) {
        this.message = message;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
