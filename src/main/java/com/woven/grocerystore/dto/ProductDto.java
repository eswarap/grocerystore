package com.woven.grocerystore.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    private Long productId;
    private String productName;
    private String description;
    private CategoryDto category;
    
    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public CategoryDto getCategory() {
        return category;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setCategoryDto(CategoryDto categoryDto) {
        this.category = categoryDto;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
}
