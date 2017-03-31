package com.woven.grocerystore.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.User;

public class SecurityServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void onSetUp() {
        // add principal object to SecurityContextHolder
        User user = new User("admin","password");
        /* fill user object */

        Authentication auth = new UsernamePasswordAuthenticationToken(user,null);

        SecurityContextHolder.getContext().setAuthentication(auth);

    }
    
    @Test
    @Ignore
    public void testFindLoggedInUserName() {

        boolean isLoggedIn = securityService.login("admin","password");        
        Assert.assertEquals(isLoggedIn,true);
        
        String loggedInUser = securityService.findLoggedInUserName();
        Assert.assertNotNull(loggedInUser);
    }
}
