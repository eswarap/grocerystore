package com.woven.grocerystore.service;

import java.util.List;

import com.woven.grocerystore.jpa.Role;

public interface RoleService extends GenericGroceryService<Role> {
    
    List<Role> list();
}
