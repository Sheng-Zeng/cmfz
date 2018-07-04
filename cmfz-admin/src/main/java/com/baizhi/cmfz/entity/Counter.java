package com.baizhi.cmfz.entity;

public class Counter {
    private String counterId;

    private String counterName;

    private String categoryId;

    private String userId;

    private Integer counterCount;

    public String getCounterId() {
        return counterId;
    }

    public void setCounterId(String counterId) {
        this.counterId = counterId == null ? null : counterId.trim();
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName == null ? null : counterName.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getCounterCount() {
        return counterCount;
    }

    public void setCounterCount(Integer counterCount) {
        this.counterCount = counterCount;
    }
}