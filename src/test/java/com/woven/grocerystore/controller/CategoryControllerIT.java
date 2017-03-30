package com.woven.grocerystore.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.woven.grocerystore.base.BaseControllerIT;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class CategoryControllerIT extends BaseControllerIT {
     
    @Test
    public void testList() throws Exception {
        super.mockMvc.perform(get("/categories/list?page=1"))
                .andExpect(status().isOk())
                .andExpect(view().name("category/list"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    @Test
    public void testEnter() throws Exception {
        super.mockMvc.perform(get("/categories/enter"))
                .andExpect(status().isOk())
                .andExpect(view().name("category/add"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testAdd() throws Exception {
        super.mockMvc.perform(post("/categories/add")
                            .param("categoryName", "prod1")
                            .param("description", "description1")
                            .param("category.categoryId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/categories/list?page=1"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
     @Test
    public void testUpdate() throws Exception {
        super.mockMvc.perform(post("/categories/update")
                            .param("categoryName", "prod1")
                            .param("description", "description1")
                            .param("category.categoryId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/categories/list?page=1"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
     @Test
    public void testDelete() throws Exception {
        super.mockMvc.perform(post("/categories/delete").param("categoryId","1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/categories/list?page=1"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    @Test
    public void testEdit() throws Exception {
        super.mockMvc.perform(get("/categories/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("category/edit"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
}
