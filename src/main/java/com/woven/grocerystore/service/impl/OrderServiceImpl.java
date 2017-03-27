package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.StoreOrder;
import com.woven.grocerystore.service.OrderService;
import com.woven.grocerystore.service.GroceryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

import java.util.Collection;

@Service(value="orderService")
@Transactional
public class OrderServiceImpl  extends GroceryService<StoreOrder>  implements OrderService {

    @Override
    public StoreOrder find(Long id) {
        return super.find(id);
    }
    
    @Override
    public StoreOrder save(StoreOrder t) {
        return super.save(t);
    }

    @Override
    public StoreOrder update(StoreOrder t) {
        return super.update(t);
    }
    
    @Override
    public Collection<StoreOrder> fetchAllOrder() {
        Query query = this.em.createQuery("from StoreOrder");
        return (Collection<StoreOrder>) query.getResultList();
    }
    
}
