package com.example.specgroupbycustommodel.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String orgId;

    private String status;

    private String shortSummary;

    @Column(columnDefinition = "boolean not null default true")
    private boolean active = true;

    public Document() {
    }

    public UUID getId() {
        return id;
    }

    public Document setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public Document setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Document setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getShortSummary() {
        return shortSummary;
    }

    public Document setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Document setActive(boolean active) {
        this.active = active;
        return this;
    }
}
