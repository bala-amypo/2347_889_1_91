package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "urgency_policies")
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private int priority;

    public UrgencyPolicy() {}

    public UrgencyPolicy(String keyword, int priority) {
        this.keyword = keyword;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
