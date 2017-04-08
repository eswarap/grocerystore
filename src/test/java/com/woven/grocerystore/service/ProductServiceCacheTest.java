package com.woven.grocerystore.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.service.impl.ProductServiceImpl;

public class ProductServiceCacheTest extends BaseIntegrationServiceTest {
    
    @Configuration
    static class ContextConfiguration {

        @Bean
        public ProductService productService() {
            ProductService productService = new ProductServiceImpl();
            // set properties, etc.
            return productService;
        }
    }

    @Autowired
    private ProductService productService;

    @Test
    public void testList() {
        List<ProductDto> dtoList1 = productService.list();
        List<ProductDto> dtoList2 = productService.list();
        Assert.assertEquals(dtoList1,dtoList2);
    }
}


