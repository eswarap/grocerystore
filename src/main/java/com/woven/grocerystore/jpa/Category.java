package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@Entity
@Access(AccessType.FIELD)
public class Category implements Serializable {

    private static final long serialVersionUID = 1l;

    public Category() {

    }

    @Id
    @Column(name="CATEGORY_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long categoryId;

    @Column(name="CATEGORY_NAME",unique = true)
    private String categoryName;

    @Column(name="DESCRIPTION")
    private String description;

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
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
}
