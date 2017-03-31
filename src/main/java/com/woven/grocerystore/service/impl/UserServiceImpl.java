package com.woven.grocerystore.service.impl;

import java.util.HashSet;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woven.grocerystore.jpa.User;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.RoleService;
import com.woven.grocerystore.service.UserService;

@Service(value="userService")
@Transactional
public class UserServiceImpl extends GroceryService<User>  implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private RoleService roleService;
    
    
    @Override
    public User findByUsername(String userName) {
      
        User user;
        try {
            TypedQuery<User> typedQuery = em.createQuery("from User WHERE userName=?", User.class);
            user = typedQuery.setParameter(1, userName).getSingleResult();
        } catch (final NoResultException  | NonUniqueResultException nre ) {
            user = null;
        }  
        return user;
    }
    
    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleService.list()));
        return super.save(user);
    }
}
