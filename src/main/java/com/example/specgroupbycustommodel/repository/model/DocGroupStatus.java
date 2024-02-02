package com.example.specgroupbycustommodel.repository.model;

public class DocGroupStatus {

    private String status;
    private Long count;

    public DocGroupStatus() {
    }

    public String getStatus() {
        return status;
    }

    public DocGroupStatus setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public DocGroupStatus setCount(Long count) {
        this.count = count;
        return this;
    }
}
