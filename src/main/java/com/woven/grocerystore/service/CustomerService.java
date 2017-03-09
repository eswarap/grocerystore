package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Customer;

import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface CustomerService extends GenericGroceryService<Customer> {
    Collection<Customer> fetchAllCustomer();
}
