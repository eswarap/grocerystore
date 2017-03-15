package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.Phone;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.PhoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;

@Service(value="phoneService")
@Transactional
public class PhoneServiceImpl extends GroceryService<Phone> implements PhoneService {
    
    @Override
    public Phone save(Phone phone) {
        return super.save(phone);
    }

    @Override
    public Phone find(Long id) {
        return super.find(id);
    }

    @Override
    public Collection<Phone> fetchAllPhone() {
        Query query = em.createQuery("from Phone");
        return (Collection<Phone>) query.getResultList();
    }
    
}
