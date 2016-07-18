package com.stacey.shop.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/17.
 */
public class Role {
    private int id;
    private String roleName;
    private String roleSign;
    private String description;
    private List<User> userList;
    private List<Permission> permissionList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleSign='" + roleSign + '\'' +
                ", description='" + description + '\'' +
                ", userList=" + userList +
                ", permissionList=" + permissionList +
                '}';
    }
}
