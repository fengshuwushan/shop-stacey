package com.stacey.shop.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/17.
 */
public class Permission {
    private int id;
    private String permissionName;
    private String permissionSign;
    private String description;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    private List<Role> roleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionSign() {
        return permissionSign;
    }

    public void setPermissionSign(String permissionSign) {
        this.permissionSign = permissionSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", permissionSign='" + permissionSign + '\'' +
                ", description='" + description + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}