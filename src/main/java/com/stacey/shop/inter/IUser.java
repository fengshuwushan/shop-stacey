package com.stacey.shop.inter;

import com.stacey.shop.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface IUser {
    @Insert("INSERT INTO `user`(id, username, password, state, create_time) VALUES (#{id}, #{username}, #{password}, #{state}, #{createTime})")
    public void insertUser(User user);
    @Select("select * FROM `user` where id = #{id}")
    public User getUserById(int id);
}
