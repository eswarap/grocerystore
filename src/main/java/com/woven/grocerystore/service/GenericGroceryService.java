package com.woven.grocerystore.service;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface GenericGroceryService<T> {
    
    T update(T t);
    T save(T t);
    T find(Long id);
    boolean delete(Long id);
    Long count();
}
