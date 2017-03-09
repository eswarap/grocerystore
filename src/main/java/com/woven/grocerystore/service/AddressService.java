package com.woven.grocerystore.service;

import java.util.Collection;

import com.woven.grocerystore.jpa.Address;

public interface AddressService {
    
    Address getAddress(final Long addressId);
    
    Address saveAddress(final Address address);
    
    public Collection<Address> fetchAllAddress();
}
