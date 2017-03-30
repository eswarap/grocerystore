package com.woven.grocerystore.service;


import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Address;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;


public class AddressServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("addressService")
    private AddressService addressService;
    
    @Test
    public void testGet() {
        Address address = addressService.find(1l);
        Assert.assertNotNull(address);
    }
    
    @Test
    public void testCreate() {
        Address lAddress = new Address("2nd Street","Bengalore","KA","560037");
        Address address = addressService.save(lAddress);
        Assert.assertNotNull(address);
    }
    
    @Test
    public void testFetchAll() {
        Collection<Address> address = addressService.fetchAllAddress();
        Assert.assertNotNull(address);
        System.out.println("address size "+address.size());
    }
    
}
