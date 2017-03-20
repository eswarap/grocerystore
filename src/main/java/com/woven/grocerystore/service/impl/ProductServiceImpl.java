package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.dto.ProductDto;
import com.woven.grocerystore.jpa.Category;
import com.woven.grocerystore.jpa.Product;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.service.CategoryService;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public Product find(Long id) {
        return super.find(id);
    }

    @Override
    public Collection<Product> fetchAllProduct() {
        Query query = em.createQuery("from Product");
        return (Collection<Product>) query.getResultList();
    }

    @Override
    public boolean update(ProductDto productDto, Long productId, Long categoryId) {
        Product product = super.find(productId);
        product = groceryMapper.map(productDto,Product.class);
        Category category = categoryService.find(categoryId);
        product.setCategory(category);
        product.setProductId(productId);
        System.out.println("product id "+product.getProductId());
        System.out.println("category id "+product.getCategory());
        em.merge(product);
        return true;
    }

}
