package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.OrderItem;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.jpa.StoreOrder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;
import java.util.Collection;

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
        OrderItem orderItem = orderItemService.find(1l);
        Assert.assertNotNull(orderItem);
    }

    @Test
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

