package com.woven.grocerystore.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/prod-context.xml"})
@ActiveProfiles("jpa-pgsql")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class BaseIntegrationServiceTest {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
}
