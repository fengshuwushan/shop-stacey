package com.stacey.shop.inter;

import com.stacey.shop.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface IRole {
    @Insert("INSERT INTO `role`(role_name, role_sign, description) value(#{roleName}, #{roleSign}, #{description})")
    public void insertRole(Role role);
    @Select("SELECT * from `role` where id = #{id}")
    public Role getRoleById(int id);
}
