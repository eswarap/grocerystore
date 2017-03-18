package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.OrderItem;
import com.woven.grocerystore.service.OrderItemService;
import com.woven.grocerystore.service.GroceryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

import java.util.Collection;

@Service(value="orderItemService")
@Transactional
public class OrderItemServiceImpl extends GroceryService<OrderItem> implements OrderItemService {

    @Override
    public Collection<OrderItem> fetchAllOrderItem() {
        Query query = this.em.createQuery("from OrderItem");
        return (Collection<OrderItem>) query.getResultList();
    }
    
    @Override
    public OrderItem find(Long id) {
        return super.find(id);
    }
    
    @Override
    public OrderItem save(OrderItem t) {
        return super.save(t);
    }
}
