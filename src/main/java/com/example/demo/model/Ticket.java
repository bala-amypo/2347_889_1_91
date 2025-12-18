package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String location;

    private String createdBy;

    @ManyToOne
    private Category assignedCategory;

    @Enumerated(EnumType.STRING)
    private UrgencyLevel urgencyLevel;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Ticket() {}

    public Long getId() { 
        return id; 
    }
    public String getDescription() { 
        return description; 
    }
    public void setAssignedCategory(Category category) { 
        this.assignedCategory = category;
    }
    public void setUrgencyLevel(UrgencyLevel urgencyLevel) { this.urgencyLevel = urgencyLevel; }
}
