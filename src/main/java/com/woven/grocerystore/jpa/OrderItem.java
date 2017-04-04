package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderItem implements Serializable {
    
     private static final long serialVersionUID = 1l;
     
     public OrderItem() {
     
     }

     @Id
     @Column(name="ORDERITEM_ID")
     @GeneratedValue(strategy=GenerationType.AUTO) 
     private Long orderItemId;
     
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="STORE_ORDER_ID")
     private StoreOrder storeOrder;

     @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="PRODUCT_ID")
     private Product product;
    
     @Column(name="UNIT_PRICE")
     private BigDecimal unitPrice;
     
     @Column(name="QUANTITY")
     private Integer quantity;
          
     public StoreOrder getStoreOrder() {
        return storeOrder;
    }
    
    public Long getOrderItemId() {
        return orderItemId;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    
    public void setStoreOrder(StoreOrder order) {
        this.storeOrder = order;
    }
    
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
     public OrderItem(StoreOrder order,Product product,BigDecimal unitPrice,int quantity) {
         this.storeOrder = order;
         this.product = product;
         this.unitPrice = unitPrice;
         this.quantity = quantity;
     }
     
     @Override
    public String toString() {
        return new StringBuilder().append("ORDERITEM_ID:").append(orderItemId).
                append(" storeOrder:").append(storeOrder==null?"null":storeOrder.toString()).
                append(" product:").append(product==null?"null":product.toString()).
                append(" unitPrice:").append(unitPrice.toString()).
                append(" quantity:").append(quantity.toString()).
                toString();
    }
}
