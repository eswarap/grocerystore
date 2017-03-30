package com.woven.grocerystore.service.impl;

import java.util.HashSet;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.woven.grocerystore.jpa.User;
import com.woven.grocerystore.jpa.Role;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.RoleService;
import com.woven.grocerystore.service.UserService;

import java.util.Set;

@Service(value="userDetailsService")
@Transactional
public class UserDetailsServiceImpl extends GroceryService<User>  implements UserDetailsService,UserService{
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private RoleService roleService;
    
    @Override
    public User findByUsername(String userName) {
        
        User user;
        try {
            TypedQuery<User> typedQuery = em.createQuery("from User WHERE column=?", User.class);
            user = typedQuery.setParameter(1, "userName").getSingleResult();
        } catch (final NoResultException  | NonUniqueResultException nre ) {
            user = null;
        }  
        return user;
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
    
    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleService.list()));
        return super.save(user);
    }
    
}
