package com.woven.grocerystore.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.woven.grocerystore.base.BaseIntegrationServiceTest;
import com.woven.grocerystore.dto.RoleDto;
import com.woven.grocerystore.dto.UserDto;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.Role;
import com.woven.grocerystore.jpa.User;
import com.woven.grocerystore.mapper.GroceryMapper;

public class UserServiceTest extends BaseIntegrationServiceTest{
    
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
 
    @Autowired
    @Qualifier("securityService")
    private SecurityService securityService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    @Qualifier("groceryMapper")
    private GroceryMapper groceryMapper;  
    
    
    @Test
    public void testFindByUserName() {
        User actual = userService.findByUsername("admin");
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testLoadUserByUsername() {
        //securityService.login("admin","password");
        UserDetails actual = userDetailsService.loadUserByUsername("admin");
        System.out.println("actual user password "+actual.getPassword());
        Assert.assertNotNull(actual);
    }
    
    @Test
    public void testSave() {
        
        User actual = new User("manager","password");
        User target = userService.save(actual);
        Assert.assertEquals(actual.getUserName(),target.getUserName());
        
    }
    
    @Test
    public void testSaveDto() {
        
        UserDto actual = new UserDto("manager","password");
        Role role = roleService.find(1l);
        List<RoleDto> roles = new ArrayList<RoleDto>();
        roles.add(groceryMapper.map(role,RoleDto.class));
        actual.setRoleList(roles);
        boolean isSaved = userService.save(actual);
        Assert.assertEquals(isSaved,true);
        
    }
    
     @Test
    public void testUpdateDto() {
        
        UserDto actual = new UserDto("manager","password");
        actual.setUserId(1l);
        Role role = roleService.find(1l);
        List<RoleDto> roles = new ArrayList<RoleDto>();
        roles.add(groceryMapper.map(role,RoleDto.class));
        actual.setRoleList(roles);
        boolean isUpdate = userService.update(actual);
        Assert.assertEquals(isUpdate,true);
        
    }
    
    @Test
    public void testList() {
    
        List<UserDto> userDtoList = userService.list(new Pagination(0,5));
        System.out.println("size ="+userDtoList.size());
        Assert.assertTrue("userDtoList",userDtoList.size()>0);
        
    }
}
