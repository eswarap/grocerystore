package com.woven.grocerystore.controller;


import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.woven.grocerystore.base.BaseControllerIT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class ProductControllerIT extends BaseControllerIT {
    
   
    @Test
    public void testList() throws Exception {
        super.mockMvc.perform(get("/products/list?page=1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/list"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    @Test
    public void testEnter() throws Exception {
        super.mockMvc.perform(get("/products/enter"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/add"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testAdd() throws Exception {
        super.mockMvc.perform(post("/products/add")
                            .param("productName", "prod1")
                            .param("description", "description1")
                            .param("category.categoryId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/list?page=1"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    @Test
    public void testEdit() throws Exception {
        super.mockMvc.perform(get("/products/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/edit"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    @Test
    public void testUpdate() throws Exception {
        super.mockMvc.perform(post("/products/update")
                            .param("productId", "1")        
                            .param("productName", "prod1")
                            .param("description", "description1")
                            .param("category.categoryId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/list?page=1"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
     
    @Test
    public void testDelete() throws Exception {
        super.mockMvc.perform(post("/products/delete").param("productId","1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/products/list?page=1"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
}
