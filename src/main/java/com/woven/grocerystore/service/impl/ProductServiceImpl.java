package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
@Service(value="productService")
@Transactional
public class ProductServiceImpl extends GroceryService<Product> implements ProductService {

    @Override
    public Product save(Product product) {
        return super.save(product);
    }

    @Override
    public Product find(Long id) {
        return super.find(id);
    }

    @Override
    public Collection<Product> fetchAllProduct() {
        Query query = em.createQuery("from Product");
        return (Collection<Product>) query.getResultList();
    }
}
