package com.example.ApiRest.domain;

import lombok.Data;

@Data
public class CategoryDto {

    private int categoryId;
    private String description;
    private boolean active;

    public CategoryDto(int categoryId, String description, boolean active) {
        this.categoryId = categoryId;
        this.description = description;
        this.active = active;
    }

    public CategoryDto(){

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
