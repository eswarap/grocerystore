package com.woven.grocerystore.service;

import java.util.Collection;

import com.woven.grocerystore.jpa.Customer;

public interface CustomerService {
    
    Customer fetchCustomer(final Long customerId);
    
    Customer saveCustomer(Customer customer);
    
    public Collection<Customer> fetchAllCustomer();
}
