package com.woven.grocerystore.service;

import com.woven.grocerystore.jpa.User;

public interface UserService  extends GenericGroceryService<User> {

    User findByUsername(String userName);
    
}
