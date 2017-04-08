package com.woven.grocerystore.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.TypedQuery;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.dto.CategoryDto;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.service.CategoryService;
import com.woven.grocerystore.service.GroceryService;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@Service(value="categoryService")
@Transactional
public class CategoryServiceImpl extends GroceryService<Category> implements CategoryService {

    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;

    @Override
    public List<CategoryDto> list(Pagination page) {
        TypedQuery<Category> query = em.createQuery("from Category",Category.class);
        query.setFirstResult(page.getFirst()!= null?page.getFirst():0);
        query.setMaxResults(page.getMax() != null ? page.getMax():Pagination.SIZE);
        List<Category> entityList = query.getResultList();
        Type listType = new TypeToken<List<CategoryDto>>() {}.getType();
        List<CategoryDto> dtoList = groceryMapper.map(entityList, listType);
        return dtoList;
    }

    @Override
    public List<CategoryDto> list() {
        
        TypedQuery<Category> query = em.createQuery("from Category",Category.class);
        List<Category> entityList = query.getResultList();
        Type listType = new TypeToken<List<CategoryDto>>() {}.getType();
        List<CategoryDto> dtoList = groceryMapper.map(entityList, listType);
        return dtoList;
    }
    
    @Override
    public Category save(Category category) {
        return super.save(category);
    }

    @Override
    public Category find(Long id) {
        return super.find(id);
    }
    
    public boolean save(CategoryDto categoryDto) {
         
        Category category = groceryMapper.map(categoryDto,Category.class);
        super.save(category);
        
        return true;
    }
    
    public boolean update(CategoryDto categoryDto) {
        
        Category category = groceryMapper.map(categoryDto,Category.class);
        super.update(category);
        
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return super.delete(id);
    }}
