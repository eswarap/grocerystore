package com.woven.grocerystore.service.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.Address;
import com.woven.grocerystore.service.AddressService;

@Service(value="addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
   
    @PersistenceContext(unitName="GS_UNIT")
    private EntityManager em;
    
    @Override
    public Address getAddress(final Long addressId) {
        return em.find(Address.class,addressId);
    }

    @Override
    public Address saveAddress(Address address) {
        em.persist(address);
        return address;
    }
}
