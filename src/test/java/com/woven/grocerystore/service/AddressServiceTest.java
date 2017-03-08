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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
@ActiveProfiles("jpa")
public class AddressServiceTest {
    
    @Autowired
    @Qualifier("addressService")
    private AddressService addressService;
    
    @Test
    public void testGetAddress() {
        Address address = addressService.getAddress(1l);
        Assert.assertNotNull(address);
        System.out.println(String.format("address is %s",address.toString()));
    }
    
    @Test
    public void testSaveAddress() {
        Address lAddress = new Address("1st Street","Bengalore","KA","560037");
        Address address = addressService.saveAddress(lAddress);
        Assert.assertNotNull(address);
        System.out.println(address.toString());
    }
}
