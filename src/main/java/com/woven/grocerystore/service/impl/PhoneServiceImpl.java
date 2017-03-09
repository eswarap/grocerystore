package com.woven.grocerystore.service.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.Phone;
import com.woven.grocerystore.service.PhoneService;

@Service(value="phoneService")
@Transactional
public class PhoneServiceImpl implements PhoneService {

    @PersistenceContext(unitName="GS_UNIT")
    private EntityManager em;
    
    @Override
    public Phone fetchPhone(Long phoneId) {
        return em.find(Phone.class, phoneId);
    }

    @Override
    public Phone savePhone(Phone phone) {
        em.persist(phone);
        return phone;
    }

    @SuppressWarnings("unchecked")
    @Override    
    public Collection<Phone> fetchAllPhone() {
        Query query = em.createQuery("from Phone");
        return (Collection<Phone>) query.getResultList();
  }
    
}
