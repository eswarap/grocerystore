package com.woven.grocerystore.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/spring-dev-context.xml"})
@ActiveProfiles("jpa-hsql")
public abstract class BaseIntegrationServiceTest {
}
