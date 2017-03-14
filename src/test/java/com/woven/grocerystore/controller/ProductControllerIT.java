package com.woven.grocerystore.controller;


import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.woven.grocerystore.controller.BaseControllerIT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerIT extends BaseControllerIT {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    
     @Test
     public void testHello() throws Exception{
         
       mockMvc.perform(get("/products/getall"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors());
    }
}
