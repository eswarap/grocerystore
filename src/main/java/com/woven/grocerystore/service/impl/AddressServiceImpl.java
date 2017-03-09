package com.woven.grocerystore.service.impl;


import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Address> fetchAllAddress() {
        Query query = em.createQuery("from Address");
        return (Collection<Address>) query.getResultList();
    }
}
