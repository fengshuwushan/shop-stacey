package com.stacey.shop.inter;

import com.stacey.shop.entity.Role;
import com.stacey.shop.entity.User;
import com.stacey.shop.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface IUserRole {
    @Insert("INSERT INTO user_role(id, user_id, role_id) VALUES (#{id}, #{userId}, #{roleId})")
    public void insertUserRole(UserRole userRole);
    @Select("select * from user_role ur, role r where ur.role_id = r.id and ur.role_id = #{role_id};")
    public User getUserByRoleId(int roleId);
    @Select("SELECT * FROM user_role ur, `user` u where ur.user_id = u.id and ur.user_id = #{user_id}")
    public Role getRoleByUserId(int userId);
}
