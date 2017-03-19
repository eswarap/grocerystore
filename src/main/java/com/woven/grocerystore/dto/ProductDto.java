package com.woven.grocerystore.dto;

public class ProductDto {
    
    private String productName;
    private String description;
    private CategoryDto category;
    
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
