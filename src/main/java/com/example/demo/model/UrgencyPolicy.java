package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "urgency_policies")
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MUST match repository method findByKeywordContainingIgnoreCase
    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String urgencyLevel;

    public UrgencyPolicy() {}

    public UrgencyPolicy(String keyword, String urgencyLevel) {
        this.keyword = keyword;
        this.urgencyLevel = urgencyLevel;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }
}
