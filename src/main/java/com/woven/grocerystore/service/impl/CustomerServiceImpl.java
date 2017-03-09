package com.woven.grocerystore.service.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.woven.grocerystore.jpa.Customer;
import com.woven.grocerystore.service.CustomerService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext(unitName="GS_UNIT")
    private EntityManager em;
    
    @Override
    public Customer fetchCustomer(final Long customerId) {
        return em.find(Customer.class, customerId);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Customer> fetchAllCustomer() {
        Query query = em.createQuery("from Customer");
        return (Collection<Customer>) query.getResultList();
    }
}
