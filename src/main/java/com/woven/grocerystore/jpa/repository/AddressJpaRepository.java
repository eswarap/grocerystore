package com.woven.grocerystore.jpa.repository;

import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.Address;

@Transactional
public interface AddressJpaRepository {
    
    Address save(Address lAddress);

    Address findByZipCode(String zipCode);
}
