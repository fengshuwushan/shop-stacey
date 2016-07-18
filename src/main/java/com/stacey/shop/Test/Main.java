package com.stacey.shop.Test;

import com.stacey.shop.entity.*;
import com.stacey.shop.inter.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Main {
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try {
            reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        testInsertPermission();
//        testGetPermission();
//        testAddRole();
//        testGetRole();
        testInsertRolePermission();
        testGetRolePermission();
        testAddUser();
        testGetUser();
        testAddUserRole();
        testGetUserRole();
    }

    public static void testInsertPermission()
    {
        System.out.println("----------添加permission begin------------");
        Permission permission = new Permission();
        permission.setDescription(null);
        permission.setPermissionName("用户修改");
        permission.setPermissionSign("user:update");
        sqlSessionFactory.getConfiguration().addMapper(IPermission.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IPermission iPermission = sqlSession.getMapper(IPermission.class);
            iPermission.insertPermission(permission);
            sqlSession.commit();
            System.out.println("----------添加permission end------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testGetPermission()
    {
        System.out.println("----------获取permission begin------------");
//        sqlSessionFactory.getConfiguration().addMapper(IPermission.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            IPermission iPermission = sqlSession.getMapper(IPermission.class);
            Permission permission = iPermission.getPermissionById(5);
            System.out.println(permission);
            System.out.println("----------获取permission end------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testAddRole()
    {
        System.out.println("----------添加role begin------------");
        sqlSessionFactory.getConfiguration().addMapper(IRole.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Role role = new Role();
        role.setId(2);
        role.setDescription("普通用户");
        role.setRoleName("normal");
        role.setRoleSign("normal user");

        try{
            IRole iRole = sqlSession.getMapper(IRole.class);
            iRole.insertRole(role);
            sqlSession.commit();
            System.out.println("----------添加role end------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testGetRole()
    {
        System.out.println("----------获取role begin------------");
//        sqlSessionFactory.getConfiguration().addMapper(IRole.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            IRole iRole = sqlSession.getMapper(IRole.class);
            Role role = iRole.getRoleById(2);
            System.out.println(role);
            System.out.println("----------获取role end------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testInsertRolePermission()
    {
        System.out.println("----------添加rolePermission begin------------");
        sqlSessionFactory.getConfiguration().addMapper(IRolePermission.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RolePermission rolePermission = new RolePermission();
        rolePermission.setPermissionId(2);
        rolePermission.setRoleId(2);
        try{
            IRolePermission iRolePermission = sqlSession.getMapper(IRolePermission.class);
            iRolePermission.insertRolePermission(rolePermission);
            sqlSession.commit();
            System.out.println("----------添加rolePermission end------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testGetRolePermission()
    {
        System.out.println("----------获取rolePermission begin------------");
//        sqlSessionFactory.getConfiguration().addMapper(IRolePermission.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IRolePermission iRolePermission = sqlSession.getMapper(IRolePermission.class);
        Permission permission = iRolePermission.getPermissionsByRoleId(2);
        System.out.println(permission);
        Role role = iRolePermission.getRoleByPermissionId(2);
        System.out.println(role);
        System.out.println("----------获取rolePermission end------------");
    }

    public static void testAddUser()
    {
        sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(2);
        user.setPassword("123456");
        user.setState(null);
        user.setUsername("stacey wu");
        user.setCreateTime(null);
        try {
            IUser iUser = sqlSession.getMapper(IUser.class);
            iUser.insertUser(user);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public static void testGetUser()
    {
        System.out.println("----------获取user end------------");
//        sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            IUser iUser = sqlSession.getMapper(IUser.class);
            User user = iUser.getUserById(2);
            System.out.println(user);
            System.out.println("----------获取user begin------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testAddUserRole()
    {
        System.out.println("----------添加userRole begin------------");
        sqlSessionFactory.getConfiguration().addMapper(IUserRole.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserRole iUserRole = sqlSession.getMapper(IUserRole.class);
        UserRole userRole = new UserRole();
        userRole.setId(2);
        userRole.setRoleId(2);
        userRole.setUserId(2);
        try {
            iUserRole.insertUserRole(userRole);
            sqlSession.commit();
            System.out.println("----------添加userRole end------------");
        }finally {
            sqlSession.close();
        }
    }

    public static void testGetUserRole(){
        System.out.println("----------获取userRole begin------------");
//        sqlSessionFactory.getConfiguration().addMapper(IUserRole.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserRole iUserRole = sqlSession.getMapper(IUserRole.class);
        Role role = iUserRole.getRoleByUserId(2);
        System.out.println(role);
        User user = iUserRole.getUserByRoleId(2);
        System.out.println(user);
        System.out.println("----------获取userRole end------------");
    }
}
