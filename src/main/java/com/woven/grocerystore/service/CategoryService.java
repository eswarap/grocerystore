package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Category;

import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface CategoryService extends GenericGroceryService<Category> {
    Collection<Category> list();
}
