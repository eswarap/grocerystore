package com.woven.grocerystore.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.FIELD)
public class OrderItem implements Serializable {
    
     private static final long serialVersionUID = 1l;
     
     @Id
     @Column(name="ORDERITEM_ID")
     @GeneratedValue(strategy=GenerationType.AUTO) 
     private Long orderItemId;
     
     @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
     @JoinColumn(name="ORDER_ID")
     private Order order;

     @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
     @JoinColumn(name="PRODUCT_ID")
     private Product product;
    
     @Column(name="UNIT_PRICE")
     private BigDecimal unitPrice;
     
     @Column(name="QUANTITY")
     private Integer quantity;
     
     public OrderItem() {
      
     }
     
     public OrderItem(Order order,Product product,BigDecimal unitPrice,int quantity) {
         this.order = order;
         this.product = product;
         this.unitPrice = unitPrice;
         this.quantity = quantity;
     }
     
     @Override
    public String toString() {
        return new StringBuilder().append("ORDERITEM_ID:").append(orderItemId).
                append(" order:").append(order==null?"null":order.toString()).
                append(" product:").append(product==null?"null":product.toString()).
                append(" unitPrice:").append(unitPrice.toString()).
                append(" quantity:").append(quantity.toString()).
                toString();
    }
}
