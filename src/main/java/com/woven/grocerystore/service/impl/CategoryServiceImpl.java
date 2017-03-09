package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.service.CategoryService;
import com.woven.grocerystore.service.GroceryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@Service(value="categoryService")
@Transactional
public class CategoryServiceImpl extends GroceryService<Category> implements CategoryService {


    @Override
    public Collection<Category> fetchAllCategory() {
        Query query = this.em.createQuery("from Category");
        return (Collection<Category>) query.getResultList();
    }

    @Override
    public Category save(Category category) {
        return super.save(category);
    }

    @Override
    public Category find(Long id) {
        return super.find(id);
    }
}
