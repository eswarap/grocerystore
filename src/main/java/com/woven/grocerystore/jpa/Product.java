package com.woven.grocerystore.jpa;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="PRODUCT")
@Access(AccessType.FIELD)
public class Product implements Serializable  {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO) 
    public Long productId;
    
    @Column(name="PRODUCTNAME")
    public String productName;
    
    @Column(name="DESCRIPTION")
    public String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_address_id")
    private Address address;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_id")
    private Phone phone;
    
    
}
