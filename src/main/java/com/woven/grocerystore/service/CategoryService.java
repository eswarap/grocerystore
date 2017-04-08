package com.woven.grocerystore.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.woven.grocerystore.dto.CategoryDto;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Pagination;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface CategoryService extends GenericGroceryService<Category> {
    
    @Cacheable("categories")
    List<CategoryDto> list(Pagination page);
    
    List<CategoryDto> list();    
    
    boolean update(final CategoryDto categoryDto);
    
    boolean save(final CategoryDto categoryDto);
}
