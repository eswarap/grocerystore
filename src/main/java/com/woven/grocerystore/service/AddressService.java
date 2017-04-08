package com.woven.grocerystore.service;

import java.util.Collection;
import com.woven.grocerystore.jpa.Address;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface AddressService extends GenericGroceryService<Address> {
    Collection<Address> fetchAllAddress();
}
