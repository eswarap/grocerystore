package com.woven.grocerystore.controller;


import com.woven.grocerystore.base.BaseControllerIT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HelloControllerIT extends BaseControllerIT {

     @Test
     public void testHello() throws Exception{
         
       super. mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));

    }
}
