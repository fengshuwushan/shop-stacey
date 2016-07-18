package com.stacey.shop.inter;

import com.stacey.shop.entity.Permission;
import com.sun.org.glassfish.gmbal.IncludeSubclass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface IPermission {
    @Insert("INSERT INTO `permission` (permission_name, permission_sign, description)\n" +
            "\t\tVALUES(#{permissionName}, #{permissionSign}, #{description});")
    public void insertPermission(Permission permission);
    @Select("select * from `permission` where id = #{id}")
    public Permission getPermissionById(int id);
}
