package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue
    private Long id;

    private String keyword;
    private String matchType;
    private Integer priority;

    @ManyToOne
    private Category category;

    private LocalDateTime createdAt;

    public CategorizationRule() {}

    @PrePersist
    public void prePersist() {
        if (priority == null) priority = 1;
        createdAt = LocalDateTime.now();
    }

    // getters & setters
}
