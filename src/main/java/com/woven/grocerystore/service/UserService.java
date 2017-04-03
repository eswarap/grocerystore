package com.woven.grocerystore.service;

import java.util.List;

import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.User;

public interface UserService  extends GenericGroceryService<User> {

    User findByUsername(String userName);
    
    List<User> list(Pagination pagination);
    
}
