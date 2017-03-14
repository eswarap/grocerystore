package com.woven.grocerystore.controller;

import org.junit.Before;

import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ActiveProfiles("jpa-pgsql")
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml",
                                  "file:src/main/resources/config/spring/prod-config.xml",
                                   "file:src/main/resources/config/spring/prod-context.xml",})
@WebAppConfiguration
public abstract class BaseControllerIT {
    
    @Autowired
    protected WebApplicationContext wac;
    
    protected MockMvc mockMvc;
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
