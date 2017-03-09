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

    @Id
    @Column(name="CATEGORY_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long categoryId;

    @Column(name="CATEGORY_NAME")
    public String categoryName;

    @Column(name="DESCRIPTION")
    public String description;

    public Category() {

    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
}
