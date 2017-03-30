package com.woven.grocerystore.jpa;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;
/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1l;

    public Category() {

    }

    
    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @Id
    @Column(name="CATEGORY_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long categoryId;

    @Column(name="CATEGORY_NAME",unique = true)
    private String categoryName;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToMany(cascade={CascadeType.REMOVE},mappedBy="category")
    private Set<Product> products;
    
    public Set<Product> getProducts() {
        return products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
       return new StringBuilder().append(" categoryName =").append(categoryName)
                                  .append(" description =").append(description)
                                  .toString();
    }
}
