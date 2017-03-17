package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.StoreOrder;

import java.util.Collection;

public interface OrderService extends GenericGroceryService<StoreOrder> {
     Collection<StoreOrder> fetchAllOrder();
}
