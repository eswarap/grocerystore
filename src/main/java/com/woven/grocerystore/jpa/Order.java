package com.woven.grocerystore.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
    
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST,mappedBy = "order")
    private Set<OrderItem> orderItem = new HashSet<OrderItem>(0);
     
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    
    @Column(name="ORDER_DATE")
    private Date orderDate;
    
    @Column(name="TOTAL")
    private Integer total;

    public Long getOrderId() {
        return orderId;
    }

    public Order setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }

    public Order setOrderItem(Set<OrderItem> orderItem) {
        this.orderItem = orderItem;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public Order setTotal(Integer total) {
        this.total = total;
        return this;
    }

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
