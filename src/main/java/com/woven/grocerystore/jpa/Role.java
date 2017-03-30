package com.woven.grocerystore.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="USER_ROLE")
public class Role {
    
    
    private Long roleId;
    private String roleName;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Column(name="ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setUserName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
