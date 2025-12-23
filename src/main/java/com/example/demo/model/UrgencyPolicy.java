package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "urgency_policies")
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String urgencyOverride;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "policy_categories",
            joinColumns = @JoinColumn(name = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    public UrgencyPolicy() {
    }

    public UrgencyPolicy(String policyName, String keyword, String urgencyOverride) {
        this.policyName = policyName;
        this.keyword = keyword;
        this.urgencyOverride = urgencyOverride;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }
 
    public String getPolicyName() {
        return policyName;
    }
 
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
 
    public String getKeyword() {
        return keyword;
    }
 
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
 
    public String getUrgencyOverride() {
        return urgencyOverride;
    }
 
    public void setUrgencyOverride(String urgencyOverride) {
        this.urgencyOverride = urgencyOverride;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
