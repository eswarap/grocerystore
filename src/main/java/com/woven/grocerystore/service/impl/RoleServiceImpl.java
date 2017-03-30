package com.woven.grocerystore.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.Role;
import com.woven.grocerystore.service.RoleService;
import com.woven.grocerystore.service.GroceryService;

@Service(value="roleService")
@Transactional
public class RoleServiceImpl extends GroceryService<Role>  implements RoleService {

    @Override
    public List<Role> list() {
        
        TypedQuery<Role> query = em.createQuery("from Role",Role.class);
        List<Role> entityList = query.getResultList();
        
        return entityList;
    }

}
