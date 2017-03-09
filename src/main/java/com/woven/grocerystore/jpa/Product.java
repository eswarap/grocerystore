package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
public class Product implements Serializable  {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO) 
    public Long productId;
    
    @Column(name="PRODUCT_NAME")
    public String productName;
    
    @Column(name="DESCRIPTION")
    public String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {

    }

    public Product(String productName,String description,Category category) {
        this.productName = productName;
        this.description = description;
        this.category = category;
    }
}
