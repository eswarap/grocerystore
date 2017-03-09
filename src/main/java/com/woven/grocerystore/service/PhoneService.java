package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Phone;

import java.util.Collection;

/**
 * Created by eswaraprasadh on 09-03-2017.
 */
public interface PhoneService extends GenericGroceryService<Phone> {
    Collection<Phone> fetchAllPhone();
}
