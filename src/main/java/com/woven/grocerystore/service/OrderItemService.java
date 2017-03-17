package com.woven.grocerystore.service;


import com.woven.grocerystore.jpa.OrderItem;

import java.util.Collection;


public interface OrderItemService extends GenericGroceryService<OrderItem> {
    Collection<OrderItem> fetchAllOrderItem();
}
