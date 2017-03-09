package com.woven.grocerystore.service;

import java.util.Collection;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
@Transactional
@ActiveProfiles("jpa")
public class PhoneServiceTest {
    
    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;
 
    @Test
    @Rollback(false)
    public void testSavePhone() {
        Random randomMobile = new Random();
        Integer mobile = randomMobile.nextInt(900000000)+100000000;
        Phone lphone = new Phone("Mobile",mobile.toString());
        Phone phone = phoneService.savePhone(lphone);
        Assert.assertNotNull(phone);
        System.out.println(String.format("phone is %s",phone.toString()));
    }
    
    @Test
    public void testFetchAllPhone() {
        Collection<Phone> phones = phoneService.fetchAllPhone();
        Assert.assertNotNull(phones);
        System.out.println("phones size"+phones.size());
    }
    
    @Test
    public void testFetchPhone() {
        Phone phone = phoneService.fetchPhone(1L);
        Assert.assertNotNull(phone);
        System.out.println(String.format("phone is %s",phone.toString()));
    }
    
}
