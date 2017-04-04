package com.woven.grocerystore.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;

public class SecurityServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;

    @Test
    public void testLogin() {
        
        Authentication authentication =
                new UsernamePasswordAuthenticationToken("admin", "password");
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        boolean isLoggedIn = securityService.login("admin", "password");
        Assert.assertNotNull(isLoggedIn);        
        String loggedInUser = securityService.findLoggedInUserName();
        Assert.assertNotNull(loggedInUser);        
    }
}

