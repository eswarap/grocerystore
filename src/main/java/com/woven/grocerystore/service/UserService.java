package com.woven.grocerystore.service;

import com.woven.grocerystore.dto.UserDto;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.User;

import java.util.List;

public interface UserService  extends GenericGroceryService<User> {

    User findByUsername(String userName);
    
    List<UserDto> list(Pagination pagination);
    
    boolean update(final UserDto userDto);
    
    boolean save(final UserDto userDto);
}
