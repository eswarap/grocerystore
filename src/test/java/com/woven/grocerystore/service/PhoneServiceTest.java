package com.woven.grocerystore.service;

import java.util.Collection;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woven.grocerystore.jpa.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})
@ActiveProfiles("jpa")
public class PhoneServiceTest {
    
    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;
 
    @Test
    public void test_Phone_jpa_methods() {
        Random randomMobile = new Random();
        Integer mobile = randomMobile.nextInt(900000000)+100000000;
        Phone lphone = new Phone("Mobile",mobile.toString());
        Phone phone = phoneService.save(lphone);
        Assert.assertNotNull(phone);
        System.out.println(String.format("phone is %s",phone.toString()));
        
        phone = phoneService.find(1l);
        Assert.assertNotNull(phone);
        System.out.println(String.format("phone is %s",phone.toString()));
        Collection<Phone> phones = phoneService.fetchAllPhone();
        Assert.assertNotNull(phones);
        System.out.println("phones size"+phones.size());       
    }

}
