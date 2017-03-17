package com.woven.grocerystore.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class StoreOrder implements Serializable {

    private static final long serialVersionUID = 1l;
    
    public StoreOrder() {
        
    }
    
    public StoreOrder(Customer customer,String orderStatus,Date orderDate,int totalQuantity){
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.totalQuantity = totalQuantity;
    }
    
    @Id
    @Column(name="STORE_ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;
    
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST,mappedBy="storeOrder")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
     
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    
    @Column(name="ORDER_DATE")
    private Date orderDate;
    
    @Column(name="TOTAL_QUANTITY")
    private Integer totalQuantity;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderItem> getOrderItem() {
        return orderItems;
    }

    public void setOrderItem(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(final String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("ORDER_ID:").append(orderId).
                append(" customer:").append(customer==null?"null":customer.toString()).
                append(" orderItems:").append(orderItems==null?"null":orderItems.toString()).
                append(" orderStatus:").append(orderStatus).
                append(" orderDate:").append(orderDate).
                append(" totalQuantity:").append(totalQuantity.toString()).
                toString();
    }
}
