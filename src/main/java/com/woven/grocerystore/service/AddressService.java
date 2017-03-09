package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Address;

import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface AddressService extends GenericGroceryService<Address> {
    Collection<Address> fetchAllAddress();
}
