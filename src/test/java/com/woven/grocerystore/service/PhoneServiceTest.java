package com.woven.grocerystore.service;

import java.util.Collection;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Phone;

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
        Random randomMobile = new Random();
        Integer mobile = randomMobile.nextInt(900000000)+100000000;
        Phone lphone = new Phone("Mobile",mobile.toString());
        Phone actualPhone = phoneService.save(lphone);
        Phone targetPhone = phoneService.find(actualPhone.getPhoneId());
        Assert.assertNotNull(actualPhone);
        Assert.assertNotNull(targetPhone);
        Assert.assertEquals(actualPhone.getPhoneType(), targetPhone.getPhoneType());
        Assert.assertEquals(actualPhone.getPhoneNumber(), targetPhone.getPhoneNumber());
    }
    
 
}
