package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Phone;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;
import java.util.Random;

public class PhoneServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;

    @Test
    public void testCreatePhone() {
        Random randomMobile = new Random();
        Integer mobile = randomMobile.nextInt(900000000)+100000000;
        Phone lphone = new Phone("Mobile",mobile.toString());
        Phone phone = phoneService.save(lphone);
        Assert.assertNotNull(phone);
    }

    @Test
    public void testFetchAllPhones() {
        Collection<Phone> phones = phoneService.fetchAllPhone();
        Assert.assertNotNull(phones);
        LOG.info("phones size"+phones.size());
    }
    
     @Test
    public void testGetPhone() {
        Phone phone = phoneService.find(1l);
        Assert.assertNotNull(phone);

    }
    
 
}
