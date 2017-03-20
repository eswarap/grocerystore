package com.woven.grocerystore.jpa;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Product implements Serializable  {
    
    private static final long serialVersionUID = 1l;
  
    public Product() {

    }
    
    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long productId;
    
    @Column(name="PRODUCT_NAME",unique = true)
    private String productName;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinColumn(name = "CATEGORY_ID",nullable=false)
    private Category category;

    public Product(String productName,String description,Category category) {
        this.productName = productName;
        this.description = description;
        this.category = category;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public Long getProductId() {
        return productId;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    @Override
    public String toString() {
          return new StringBuilder().append(" productId : ").append(productId)
                                   .append(" description: ").append(description)
                                   .append(" category: ").append(category==null?"null":category.toString())
                                   .toString();
    }
}
