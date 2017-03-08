package com.woven.grocerystore.jpa.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.Address;
import com.woven.grocerystore.jpa.repository.AddressJpaRepository;

@Repository
@Transactional
public class AddressJpaRepositoryImpl implements AddressJpaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Address save(Address lAddress) {
        return em.merge(lAddress);
    }

    @Override
    public Address findByZipCode(String zipCode) {
        return em.find(Address.class, zipCode);
    }


}
