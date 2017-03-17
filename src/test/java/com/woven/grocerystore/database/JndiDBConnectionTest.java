package com.woven.grocerystore.database;


import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/prod-context.xml"})
@ActiveProfiles("jpa-pqsql")
public class JndiDBConnectionTest {
   
  @Autowired(required=true)
  private DataSource dataSource;
   
   @Test
   public void testDbConnection() throws Exception {
        Connection conn = dataSource.getConnection();   
        Assert.assertNotNull(conn);     
    }
   
}
