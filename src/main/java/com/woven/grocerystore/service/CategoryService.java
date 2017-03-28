package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Page;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.dto.CategoryDto;

import java.util.List;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface CategoryService extends GenericGroceryService<Category> {
    
    List<CategoryDto> list(Page page);
    
    boolean update(final CategoryDto categoryDto);
    
    boolean save(final CategoryDto categoryDto);
}
