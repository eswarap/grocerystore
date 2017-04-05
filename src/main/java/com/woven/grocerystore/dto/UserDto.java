package com.woven.grocerystore.dto;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    private Long userId;
    private String userName;
    private String password;
    private List<RoleDto> roleList;
    
    protected UserDto() {

    }
    
    public UserDto(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDto> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<RoleDto> roleList) {
        this.roleList = roleList;
    }
}
