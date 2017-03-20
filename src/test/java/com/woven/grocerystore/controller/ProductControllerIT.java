package com.woven.grocerystore.controller;


import javax.ws.rs.core.MediaType;

import com.woven.grocerystore.base.BaseControllerIT;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.dto.CategoryDto;

import org.junit.Test;
import org.junit.Before;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerIT extends BaseControllerIT {
    
    private ProductDto productDto;
    private CategoryDto categoryDto;
    
    @Before
    public void setUp() {
        productDto = new ProductDto();
        productDto.setProductId(1l);
        productDto.setProductName("PROD");
        productDto.setDescription("description");
        categoryDto = new CategoryDto();
        categoryDto.setCategoryId(1l);
        categoryDto.setCategoryName("category");
        categoryDto.setDescription("description");
        productDto.setCategoryDto(categoryDto);
    }
    @Test
    public void testGetAllProducts() throws Exception {
        super.mockMvc.perform(get("/products/getall"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testAddProduct() throws Exception {

        super.mockMvc.perform(post("/products/add").contentType(MediaType.APPLICATION_FORM_URLENCODED).sessionAttr("product", productDto))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testUpdateProduct() throws Exception {

        super.mockMvc.perform(post("/products/edit").contentType(MediaType.APPLICATION_FORM_URLENCODED).sessionAttr("product", productDto))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
}
