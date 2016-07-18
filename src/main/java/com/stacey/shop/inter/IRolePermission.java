package com.stacey.shop.inter;

import com.stacey.shop.entity.Permission;
import com.stacey.shop.entity.Role;
import com.stacey.shop.entity.RolePermission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface IRolePermission {
    @Insert("INSERT INTO role_permission(permission_id, role_id) values (#{permissionId}, #{roleId})")
    public void insertRolePermission(RolePermission rolePermission);
    @Select("select p.*, rp.id, rp.role_id from permission p, role_permission rp where p.id = rp.permission_id and rp.permission_id = #{permission_id}")
    public Permission getPermissionsByRoleId(int roleId);
    @Select("select r.*, rp.permission_id, rp.id from role r, role_permission rp where r.id = rp.role_id and rp.role_id = #{role_id}")
    public Role getRoleByPermissionId(int permissionId);
}
