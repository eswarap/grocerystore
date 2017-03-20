package com.woven.grocerystore.service;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.jpa.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public class CategoryServiceTest extends BaseIntegrationServiceTest {

    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @Test
    public void testGetCategory() {
        Category category = categoryService.find(1l);
        Assert.assertNotNull(category);
    }

    @Test
    public void testCreateCategory() {
        Category lcategory = new Category("TV","Electronics");
        Category category = categoryService.save(lcategory);
        Assert.assertNotNull(category);
    }

    @Test
    public void testFetchAllCategory() {
        Collection<Category> categories = categoryService.fetchAllCategory();
        Assert.assertNotNull(categories);
        System.out.println("categories size "+categories.size());
    }
}
