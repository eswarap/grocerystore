package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Product;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

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
        Category lcategory = new Category("Mobile","Handheld");
        Category category = categoryService.save(lcategory);
        Product product = new Product("LED Smart TV","Samsung 52 inch",category);
        productService.save(product);
        assertNotNull(product);
    }

    @Test
    public void testFetchAllProduct() {
        Collection<Product> products = productService.fetchAllProduct();
        assertNotNull(products);
        Assert.assertTrue("product size",products.size()>=1);
    }
    
    @Test
    public void testGetProduct() {
        Category category = categoryService.find(1l);
        Product actual = new Product("Samsung","Samsung 52 inch",category);
        productService.save(actual);
        Product target = productService.find(actual.getProductId());
        assertNotNull(actual);
        assertNotNull(target);
    }
    
}
