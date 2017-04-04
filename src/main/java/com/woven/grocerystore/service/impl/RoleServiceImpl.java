package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.jpa.Role;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

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
