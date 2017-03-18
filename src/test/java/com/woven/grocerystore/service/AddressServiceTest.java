package com.woven.grocerystore.service;



import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Address;


public class AddressServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("addressService")
    private AddressService addressService;
    
    @Test
    public void testGetAddress() {
        Address address = addressService.find(1l);
    }
    
    @Test
    public void testCreateAddress() {
        Address lAddress = new Address("2nd Street","Bengalore","KA","560037");
        Address address = addressService.save(lAddress);
        Assert.assertNotNull(address);
    }
    
    @Test
    public void testFetchAllAddress() {
        Collection<Address> address = addressService.fetchAllAddress();
        Assert.assertNotNull(address);
        System.out.println("address size "+address.size());
    }
    
}
