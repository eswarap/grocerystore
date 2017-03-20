package com.woven.grocerystore.controller;


import com.woven.grocerystore.base.BaseControllerIT;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.dto.CategoryDto;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerIT extends BaseControllerIT {

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
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Philips");
        productDto.setDescription("LED 45 Inch");
        super.mockMvc.perform(post("/products/add").requestAttr("product", productDto))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testUpdateProduct() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Philips");
        productDto.setDescription("LED 45 Inch");

        super.mockMvc.perform(post("/products/edit/{prodId}/{catId}", 1l,1l).sessionAttr("product", productDto))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
}
