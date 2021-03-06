package com.woven.grocerystore.dto;

import java.io.Serializable;
import java.util.Objects;

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
    
    public void setCategory(CategoryDto categoryDto) {
        this.category = categoryDto;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(description,productName);
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (o == this) return true;
        if (!(o instanceof ProductDto)) {
            return false;
        }
        ProductDto productDto = (ProductDto) o;
        return description == productDto.description &&
                Objects.equals(productName, productDto.productName);

    }
}
