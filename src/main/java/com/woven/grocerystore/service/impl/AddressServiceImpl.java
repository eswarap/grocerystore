package com.woven.grocerystore.service.impl;


import com.woven.grocerystore.jpa.Address;
import com.woven.grocerystore.service.AddressService;
import com.woven.grocerystore.service.GroceryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;

@Service(value="addressService")
@Transactional
public class AddressServiceImpl extends GroceryService<Address>  implements AddressService {

    @Override
    public Collection<Address> fetchAllAddress() {
        Query query = this.em.createQuery("from Address");
        return (Collection<Address>) query.getResultList();
    }

    @Override
    public Address save(Address address) {
       return super.save(address);
    }
    
     @Override
    public Address update(Address address) {
       return super.update(address);
    }

    @Override
    public Address find(Long addressId) {
        return super.find(addressId);
    }

    @Override
    public boolean delete(Long id) {
        return super.delete(id);
    }
}
