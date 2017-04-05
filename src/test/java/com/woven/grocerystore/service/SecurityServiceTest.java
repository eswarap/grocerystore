package com.woven.grocerystore.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;


import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import org.springframework.security.test.context.support.WithUserDetails;


public class SecurityServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;

    @Test
    public void testLogin() {

        boolean isLoggedIn = securityService.login("admin", "password");
        Assert.assertNotNull(isLoggedIn);
    }
}

