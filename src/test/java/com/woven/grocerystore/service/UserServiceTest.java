package com.woven.grocerystore.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.User;

public class UserServiceTest extends BaseIntegrationServiceTest{
    
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
 
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;
    
    @Test
    public void testFindByUserName() {
        User actual = userService.findByUsername("admin");
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testLoadUserByUsername() {
        //securityService.login("admin","password");
        UserDetails actual = userDetailsService.loadUserByUsername("admin");
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testSave() {
        
        User actual = new User("manager","password");
        User target = userService.save(actual);
        Assert.assertEquals(actual.getUserName(),target.getUserName());
        
    }
    
    @Test
    public void testList() {
    
        List<User> userList = userService.list(new Pagination(0,5));
        System.out.println("size ="+userList.size());
        Assert.assertTrue("userList",userList.size()>0);
        
    }
}
