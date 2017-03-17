package com.woven.grocerystore.service;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.StoreOrder;
import com.woven.grocerystore.jpa.Customer;

public class OrderServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;


    @Test
    public void testGetOrder() {
        Customer customer = customerService.find(1l);
        StoreOrder lOrder = new StoreOrder(customer,"Initiated",new Date(),1);
        StoreOrder actual = orderService.save(lOrder);
        StoreOrder target = orderService.find(actual.getOrderId());
        Assert.assertNotNull(actual);
        Assert.assertNotNull(target);
    }

    @Test
    public void testCreateOrder() {
        Customer customer = customerService.find(1l);
        StoreOrder lOrder = new StoreOrder(customer,"Initiated",new Date(),1);
        StoreOrder actual = orderService.save(lOrder);
        
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFetchAllOrder() {
        Collection<StoreOrder> orders = orderService.fetchAllOrder();
        Assert.assertNotNull(orders);
        System.out.println("orders size "+orders.size());
    }
}
