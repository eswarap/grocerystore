package com.woven.grocerystore.controller;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.woven.grocerystore.base.BaseControllerIT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class ProductControllerIT extends BaseControllerIT {
    
   
    @Test
    public void testGetAllProducts() throws Exception {
        super.mockMvc.perform(get("/products/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/list"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

}
