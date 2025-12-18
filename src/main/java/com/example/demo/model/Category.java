package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "categories",
    uniqueConstraints = @UniqueConstraint(columnNames = "categoryName")
)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    private String categoryName;

    private String description;

    @NotBlank(message = "Default urgency is required")
    private String defaultUrgency;

    private LocalDateTime createdAt;

    public Category() {
    }

    public Category(String categoryName, String description, String defaultUrgency) {
        this.categoryName = categoryName;
        this.description = description;
        this.defaultUrgency = defaultUrgency;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDefaultUrgency() { return defaultUrgency; }
    public void setDefaultUrgency(String defaultUrgency) { this.defaultUrgency = defaultUrgency; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
