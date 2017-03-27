package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.service.CategoryService;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.ProductService;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.TypedQuery;

import java.lang.reflect.Type;

import java.util.List;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@Service(value="productService")
@Transactional
public class ProductServiceImpl extends GroceryService<Product> implements ProductService {

    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;

    @Override
    public Product save(Product product) {
        return super.save(product);
    }

    @Override
    public Product update(Product product) {
        return super.update(product);
    }


    @Override
    public Product find(Long id) {
        return super.find(id);
    }

    @Override
    public List<ProductDto> list() {
        TypedQuery<Product> query = em.createQuery("from Product",Product.class);
        List<Product> entityList = query.getResultList();
        Type listType = new TypeToken<List<ProductDto>>() {}.getType();
        List<ProductDto> dtoList = groceryMapper.map(entityList, listType);
        return dtoList;
    }

    public boolean save(ProductDto productDto) {
        Product product = groceryMapper.map(productDto,Product.class);
        System.out.println("##########productDto "+productDto.getProductName());
        System.out.println("##########product "+product.getProductName());
        Category category = categoryService.find(productDto.getCategory().getCategoryId());
        product.setCategory(category);
        super.save(product);
        
        return true;
    }
    
    public boolean update(ProductDto productDto) {
        Product product = groceryMapper.map(productDto,Product.class);
        System.out.println("##########productDto "+productDto.getProductName());
        System.out.println("##########product "+product.getProductName());
        Category category = categoryService.find(productDto.getCategory().getCategoryId());
        product.setCategory(category);
        super.save(product);
        
        return true;
    }

}
