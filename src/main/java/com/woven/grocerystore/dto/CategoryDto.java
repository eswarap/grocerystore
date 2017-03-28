package com.woven.grocerystore.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {
    
    private static final long serialVersionUID = 1l;
        
    private Long categoryId;    
    private String categoryName;
    private String description;    
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
}
