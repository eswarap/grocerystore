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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinColumn(name="ORDERITEM_ID")
    private OrderItem orderItem;
    
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    
    @Column(name="ORDER_DATE")
    private Date orderDate;
    
    @Column(name="TOTAL")
    private Integer total;
    
    @Override
    public String toString() {
        return new StringBuilder().append("ORDER_ID:").append(orderId).
                append(" customer:").append(customer==null?"null":customer.toString()).
                append(" orderItem:").append(orderItem==null?"null":orderItem.toString()).
                append(" orderStatus:").append(orderStatus).
                append(" orderDate:").append(orderDate).
                append(" TOTAL:").append(total.toString()).
                toString();
    }
}
