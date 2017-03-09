package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.Customer;
import com.woven.grocerystore.service.CustomerService;
import com.woven.grocerystore.service.GroceryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;

@Service(value="customerService")
@Transactional
public class CustomerServiceImpl extends GroceryService<Customer> implements CustomerService {


    @Override
    public Collection<Customer> fetchAllCustomer() {
        Query query = em.createQuery("from Customer");
        return (Collection<Customer>) query.getResultList();
    }

    @Override
    public Customer save(Customer customer) {
        return super.save(customer);
    }

    @Override
    public Customer find(Long id) {
        return super.find(id);
    }
}
