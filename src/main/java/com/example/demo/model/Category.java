package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = "categoryName")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    private String description;

    @Column(nullable = false)
    private String defaultUrgency;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "assignedCategory")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "category")
    private List<CategorizationRule> rules;

    public Category() {
    }

    public Category(String categoryName, String description, String defaultUrgency) {
        this.categoryName = categoryName;
        this.description = description;
        this.defaultUrgency = defaultUrgency;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
 
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public String getDefaultUrgency() {
        return defaultUrgency;
    }
 
    public void setDefaultUrgency(String defaultUrgency) {
        this.defaultUrgency = defaultUrgency;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
