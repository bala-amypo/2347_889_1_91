package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String categoryName;

    private String description;
    private String defaultUrgency;

    @ManyToMany
    private Set<UrgencyPolicy> urgencyPolicies = new HashSet<>();

    private LocalDateTime createdAt;

    public Category() {}

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
}
