package com.woven.grocerystore.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public abstract class GroceryService<T> implements GenericGroceryService<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GroceryService() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T save(T t) {
        this.em.merge(t);
        return t;
    }

    @Override
    public T find(Long id) {
        return em.find(type,id);
    }
    
}
