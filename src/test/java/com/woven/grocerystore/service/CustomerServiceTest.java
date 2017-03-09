package com.woven.grocerystore.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woven.grocerystore.jpa.Address;
import com.woven.grocerystore.jpa.Customer;
import com.woven.grocerystore.jpa.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
@ActiveProfiles("jpa")
public class CustomerServiceTest {
    
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
    public void test_customer_jpa_methods() {
        Address address = addressService.find(1l);
        Phone phone = phoneService.find(1l);
        Customer lcustomer = new Customer("Arun","arun@nomanworld.com",address,phone);
        Customer customer = customerService.save(lcustomer);
        Assert.assertNotNull(customer);
        System.out.println("###########"+customer.toString());
        customer = customerService.find(1l);
        Assert.assertNotNull(customer);
        System.out.println(String.format("customer is %s",customer.toString()));
    }

}
