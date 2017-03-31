package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.User;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserServiceTest extends BaseIntegrationServiceTest{
    
    @Autowired
    @Qualifier("userDetailsService")
    private UserService userService;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
    
    
    @Test
    public void testFindByUserName() {
        User actual = userService.findByUsername("admin");
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testLoadUserByUsername() {
        UserDetails actual = userDetailsService.loadUserByUsername("admin");
        Assert.assertNotNull(actual);
    }
}
