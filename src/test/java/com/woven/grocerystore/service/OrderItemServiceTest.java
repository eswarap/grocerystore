package com.woven.grocerystore.service;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.OrderItem;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.jpa.StoreOrder;

public class OrderItemServiceTest extends BaseIntegrationServiceTest  {
   
    @Autowired
    @Qualifier("productService")
    private ProductService productService;
    
    @Autowired
    @Qualifier("orderItemService")
    private OrderItemService orderItemService;

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;
    
    @Test
    public void testGetOrderItem() {
        OrderItem orderItem = orderItemService.find(1l);
        Assert.assertNotNull(orderItem);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateOrderItem() {
        Product product = productService.find(1l);
        StoreOrder storeOrder = orderService.find(1l);
        Assert.assertNotNull(product);
        Assert.assertNotNull(storeOrder);
        OrderItem lOrderItem = new OrderItem(storeOrder,product,new BigDecimal("12323"),1);
        OrderItem actual = orderItemService.save(lOrderItem);
        
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFetchAllOrderItem() {
        Collection<OrderItem> orderItems = orderItemService.fetchAllOrderItem();
        Assert.assertNotNull(orderItems);
        System.out.println("orderItems size "+orderItems.size());
    }
}

