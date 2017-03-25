package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.dto.CategoryDto;
import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Product;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public class ProductServiceTest extends BaseIntegrationServiceTest {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @Test
    public void testCreateProduct() {
        Category category = categoryService.find(1l);
        assertNotNull(category);
        Product product = new Product("BTWin","Singe cycle",category);
        productService.save(product);
        assertNotNull(product);
    }
    
    @Test
    public void testFetchAllProduct() {
        List<ProductDto> products = productService.list();
        assertNotNull(products);
        LOG.info(String.format("products size %s",products.size()));
        Assert.assertTrue("product size",products.size()>=1);
    }
    
    @Test
    public void testGetProduct() {
        Product product = productService.find(1l);
        assertNotNull(product);
        assertNotNull(product.getCategory());
        LOG.info(String.format("category %s",product.getCategory().getCategoryName()));
    }
    
     @Test
    public void testUpdateProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(1l);
        productDto.setProductName("PROD");
        productDto.setDescription("description");
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(1l);
        categoryDto.setCategoryName("category");
        categoryDto.setDescription("description");
        productDto.setCategory(categoryDto);
        boolean updated = productService.update(productDto);
        Assert.assertEquals(updated,true);
        Product product = productService.find(1l);
        assertNotNull(product);
        System.out.println(String.format("product %s",product));
        Assert.assertEquals("PROD",product.getProductName());
        Assert.assertEquals("description",product.getDescription()); 
    }
    
}
