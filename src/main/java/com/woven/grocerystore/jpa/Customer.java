package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable  {

    private static final long serialVersionUID = 1l;
    
    @Id
    @Column(name="CUSTOMER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long customerId;
    
    @Column(name="CUSTOMER_NAME")
    private String customerName;
    
    @Column(name="EMAIL")
    private String email;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ADDRESS_ID")
    private Address address;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PHONE_ID")
    private Phone phone;
  
    public Customer() {
        
    }
    
    public Customer(String customerName,String email,Address address,Phone phone) {
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return new StringBuilder().append(" customerId =").append(customerId)
                                  .append(" customerName =").append(customerName)
                                  .append(" email =").append(email)
                                  .append(" address =").append(address==null?"null":address.toString())
                                  .append(" phone =").append(phone==null?"null":phone.toString())
                                  .toString();
    }
}

