package com.woven.grocerystore.controller;


import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.woven.grocerystore.base.BaseControllerIT;
import com.woven.grocerystore.dto.ProductDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerIT extends BaseControllerIT {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    
     @Test
     public void testGetAllProducts() throws Exception{
         
       mockMvc.perform(get("/products/getall"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    @Test
    @Ignore
    public void testUpdateProduct() throws Exception{
       ProductDto productDto = new ProductDto();  
       productDto.setProductName("Philips");
       productDto.setDescription("LED 45 Inch");
       mockMvc.perform(post("/products/edit").param("id", "1").requestAttr("product",productDto))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
}
