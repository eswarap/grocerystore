package com.woven.grocerystore.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.security.test.context.support.WithUserDetails;


public class SecurityServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    public void testLogin() {

        Authentication authentication =
                new UsernamePasswordAuthenticationToken("admin", "password");
        SecurityContext securityContext = SecurityContextHolder.getContext();

        securityContext.setAuthentication(authenticationManager.authenticate(authentication));

        boolean isLoggedIn = securityService.login("admin", "password");
        Assert.assertNotNull(isLoggedIn);
    }

    @Test
    @Ignore
    @WithUserDetails(value = "admin")
    public void test() {
        String loggedInUser = securityService.findLoggedInUserName();
        Assert.assertNotNull(loggedInUser);
    }
}

