package com.woven.grocerystore.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Address;
import com.woven.grocerystore.jpa.Customer;
import com.woven.grocerystore.jpa.Phone;

import java.util.Collection;

public class CustomerServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("customerService")
    private CustomerService customerService;
    
    @Autowired
    @Qualifier("addressService")
    private AddressService addressService;
    
    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;
    
    @Test
    public void testGetCustomer() {
        Customer customer = customerService.find(1l);
        Assert.assertNotNull(customer);
    }

    @Test
    public void testCreateCustomer() {
        Address address = addressService.find(11l);
        Phone phone = phoneService.find(4l);
        Customer lcustomer = new Customer("Arun","arun@nomanworld.com",address,phone);
        Customer customer = customerService.save(lcustomer);
        Assert.assertNotNull(customer);
    }

    @Test
    public void testFetchAllCustomer() {
        Collection<Customer> customers = customerService.fetchAllCustomer();
        Assert.assertNotNull(customers);
    }

}
