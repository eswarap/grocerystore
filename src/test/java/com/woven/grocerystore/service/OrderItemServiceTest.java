package com.woven.grocerystore.service;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.OrderItem;
import com.woven.grocerystore.jpa.StoreOrder;
import com.woven.grocerystore.jpa.Product;

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
    
    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;


    @Test
    public void testGetOrderItem() {
        Product product = productService.find(1l);
        StoreOrder storeOrder = orderService.find(1l);
        OrderItem lOrderItem = new OrderItem(storeOrder,product,new BigDecimal("12323"),1);
        OrderItem actual = orderItemService.save(lOrderItem);
        OrderItem target = orderItemService.find(actual.getOrderItemId());
        Assert.assertNotNull(actual);
        Assert.assertNotNull(target);
    }

    @Test
    public void testCreateOrderItem() {
        Product product = productService.find(1l);
        StoreOrder storeOrder = orderService.find(1l);
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

