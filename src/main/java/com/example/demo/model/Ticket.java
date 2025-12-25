package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String location;
    private String createdBy;
    private String urgencyLevel;

    @ManyToOne
    private Category assignedCategory;

    private LocalDateTime createdAt;

    public Ticket() {}

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (urgencyLevel == null) urgencyLevel = "LOW";
    }

    // getters & setters
}
