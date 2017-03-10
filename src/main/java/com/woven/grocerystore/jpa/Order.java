package com.woven.grocerystore.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.FIELD)
public class Order implements Serializable {

    private static final long serialVersionUID = 1l;
    
    public Order() {
        
    }
    
    public Order(Customer customer,String orderStatus,Date orderDate,int total){
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.total = total;
    }
    
    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    private Customer customer;
    
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    
    @Column(name="ORDER_DATE")
    private Date orderDate;
    
    @Column(name="TOTAL")
    private int total;
    
    
}
