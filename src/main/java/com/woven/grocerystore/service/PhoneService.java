package com.woven.grocerystore.service;

import java.util.Collection;

import com.woven.grocerystore.jpa.Phone;

public interface PhoneService {
    
    Phone fetchPhone(final Long phoneId);
    
    Phone savePhone(final Phone phone);
    
    public Collection<Phone> fetchAllPhone();
}
