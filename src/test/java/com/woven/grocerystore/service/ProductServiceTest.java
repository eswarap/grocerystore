package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
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
    public void testGetProduct() {
        Product product = productService.find(1l);
        assertNotNull(product);
        assertEquals(product.productId.longValue(),1l);
    }

    @Test
    public void testSaveProduct() {
        Category category = categoryService.find(1l);
        Product product = new Product("LED Smart TV","Samsung 52 inch",category);
        productService.save(product);
        assertNotNull(product);
        assertEquals(1l,product.productId.longValue());
    }

    @Test
    public void testFetchAllProduct() {
        Collection<Product> products = productService.fetchAllProduct();
        assertNotNull(products);
        assertEquals(1,products.size());
    }
}
