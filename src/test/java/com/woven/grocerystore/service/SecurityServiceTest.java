package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class SecurityServiceTest extends BaseIntegrationServiceTest {
    
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;
    
    @Test
    public void testFindLoggedInUserName() {
        String loggedInUser = securityService.findLoggedInUserName();
        Assert.assertNotNull(loggedInUser);
    }
}
