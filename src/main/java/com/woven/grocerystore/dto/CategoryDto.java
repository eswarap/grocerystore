package com.woven.grocerystore.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {
    
    private static final long serialVersionUID = 1l;
        
    private String categoryName;
    private String description;    
    
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
