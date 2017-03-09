package com.woven.grocerystore.service;

import java.util.Collection;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.woven.grocerystore.jpa.Phone;

public class PhoneServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;
 
    @Test
    public void testGetPhone() {
        Phone phone = phoneService.find(1l);
        Assert.assertNull(phone);
    }

    @Test
    public void testSavePhone() {
        Random randomMobile = new Random();
        Integer mobile = randomMobile.nextInt(900000000)+100000000;
        Phone lphone = new Phone("Mobile",mobile.toString());
        Phone phone = phoneService.save(lphone);
        Assert.assertNotNull(phone);
    }

    @Test
    public void testFetchAllPhone() {
        Collection<Phone> phones = phoneService.fetchAllPhone();
        Assert.assertNotNull(phones);
        System.out.println("phones size"+phones.size());
    }

}
