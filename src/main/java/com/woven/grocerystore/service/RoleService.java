package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.Role;

import java.util.List;

public interface RoleService extends GenericGroceryService<Role> {
    
    List<Role> list();
}
