package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    @ManyToOne
    private Category category;

    public CategorizationRule() {}

    public CategorizationRule(String keyword, Category category) {
        this.keyword = keyword;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
