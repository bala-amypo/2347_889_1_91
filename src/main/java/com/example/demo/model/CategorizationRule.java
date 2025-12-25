package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rules")
public class CategorizationRule {

    @Id
    @GeneratedValue
    private Long id;

    private String keyword;
    private String matchType;
    private Integer priority;

    @ManyToOne
    private Category category;

    @PrePersist
    public void prePersist() {
        if (priority == null) priority = 1;
    }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
