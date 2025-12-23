package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_rules")
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String matchType;

    @Column(nullable = false)
    private Integer priority = 1;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public CategorizationRule() {
    }

    public CategorizationRule(Category category, String keyword, String matchType, Integer priority) {
        this.category = category;
        this.keyword = keyword;
        this.matchType = matchType;
        this.priority = priority != null ? priority : 1;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.priority == null || this.priority <= 0) {
            this.priority = 1;
        }
    }

    public Long getId() {
        return id;
    }
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public String getKeyword() {
        return keyword;
    }
 
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
 
    public String getMatchType() {
        return matchType;
    }
 
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
 
    public Integer getPriority() {
        return priority;
    }
 
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
