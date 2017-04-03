package com.woven.grocerystore.dto;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    private Long userId;
    private String userName;
    
    List<RoleDto> roleList;
    
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


    public List<RoleDto> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<RoleDto> roleList) {
        this.roleList = roleList;
    }
}
