package com.woven.grocerystore.controller;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.woven.grocerystore.base.BaseControllerIT;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.dto.CategoryDto;

import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerIT extends BaseControllerIT {
    
    private ProductDto productDto;
    private CategoryDto categoryDto;
    
    @InjectMocks
    private ProductController productController;
    
    protected MockMvc productMockMvc;
    
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
        this.productMockMvc = MockMvcBuilders.standaloneSetup(productController).build();

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

        productMockMvc.perform(post("/products/add").param("productName", "PROD"))            
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testUpdateProduct() throws Exception {

       productMockMvc.perform(post("/products/edit").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(ProductControllerIT.convertObjectToFormUrlEncodedBytes(productDto))
        )
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
    
    public static byte[] convertObjectToFormUrlEncodedBytes(Object object) {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Map<String, Object> propertyValues = mapper.convertValue(object, Map.class);

        Set<String> propertyNames = propertyValues.keySet();
        Iterator<String> nameIter = propertyNames.iterator();

        StringBuilder formUrlEncoded = new StringBuilder();

        for (int index=0; index < propertyNames.size(); index++) {
            String currentKey = nameIter.next();
            Object currentValue = propertyValues.get(currentKey);

            formUrlEncoded.append(currentKey);
            formUrlEncoded.append("=");
            formUrlEncoded.append(currentValue);

            if (nameIter.hasNext()) {
                formUrlEncoded.append("&");
            }
        }

        return formUrlEncoded.toString().getBytes();
    }
}
