package com.woven.grocerystore.controller;


import com.woven.grocerystore.base.BaseControllerIT;

import org.junit.Test;

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
