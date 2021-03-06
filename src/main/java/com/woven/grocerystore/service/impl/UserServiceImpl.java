package com.woven.grocerystore.service.impl;

import com.woven.grocerystore.dto.UserDto;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.Role;
import com.woven.grocerystore.jpa.User;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.service.GroceryService;
import com.woven.grocerystore.service.RoleService;
import com.woven.grocerystore.service.UserService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value="userService")
@Transactional
public class UserServiceImpl extends GroceryService<User>  implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private RoleService roleService;

    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;    
    
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
    
    @Override
    public List<UserDto> list(Pagination pagination) {
        TypedQuery<User> query = em.createQuery("from User",User.class);
        query.setFirstResult(pagination.getFirst()!= null?pagination.getFirst():0);
        query.setMaxResults(pagination.getMax() != null ? pagination.getMax():Pagination.SIZE);
        List<User> entityList = query.getResultList();
        
        Type listType = new TypeToken<List<UserDto>>() {}.getType();
        List<UserDto> dtoList = groceryMapper.map(entityList, listType);
        return dtoList;
    }

    @Override
    public boolean update(UserDto userDto) {
        User user = groceryMapper.map(userDto,User.class);
        Set<Role> roles = userDto.getRoleList().stream().map(roleDto -> roleService.find(roleDto.getRoleId())).collect(Collectors.toSet());
        user.setRoles(roles);
        super.update(user);
        return true;
    }

    @Override
    public boolean save(UserDto userDto) {
        User user = groceryMapper.map(userDto,User.class);
        Set<Role> roles = userDto.getRoleList().stream().map(roleDto -> roleService.find(roleDto.getRoleId())).collect(Collectors.toSet());
        user.setRoles(roles);
        super.save(user);
        return true;
    }
}
