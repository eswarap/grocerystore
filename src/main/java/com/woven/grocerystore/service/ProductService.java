package com.woven.grocerystore.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.Product;

/**
 * Created by eswarap on 09-03-2017.
 */
public interface ProductService extends GenericGroceryService<Product>{
    
    List<ProductDto> list();

    @Cacheable("products")
    List<ProductDto> list(Pagination pagination);
        
    boolean update(final ProductDto productDto);
    
    boolean save(final ProductDto productDto);
}
