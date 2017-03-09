package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Product;

import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface ProductService extends GenericGroceryService<Product>{
    Collection<Product> fetchAllProduct();
}
