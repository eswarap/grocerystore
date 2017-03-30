package com.woven.grocerystore.service;

import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.jpa.Pagination;

import java.util.List;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface ProductService extends GenericGroceryService<Product>{
    
    List<ProductDto> list();

    List<ProductDto> list(Pagination pagination);
        
    boolean update(final ProductDto productDto);
    
    boolean save(final ProductDto productDto);
}
