package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;

    @ManyToOne
    private Category category;

    @ManyToOne
    private UrgencyPolicy urgencyPolicy;

    private LocalDateTime categorizedAt;

    public CategorizationLog() {}

    public CategorizationLog(Long ticketId, Category category, UrgencyPolicy urgencyPolicy) {
        this.ticketId = ticketId;
        this.category = category;
        this.urgencyPolicy = urgencyPolicy;
        this.categorizedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public Category getCategory() {
        return category;
    }

    public UrgencyPolicy getUrgencyPolicy() {
        return urgencyPolicy;
    }

    public LocalDateTime getCategorizedAt() {
        return categorizedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUrgencyPolicy(UrgencyPolicy urgencyPolicy) {
        this.urgencyPolicy = urgencyPolicy;
    }

    public void setCategorizedAt(LocalDateTime categorizedAt) {
        this.categorizedAt = categorizedAt;
    }
}
