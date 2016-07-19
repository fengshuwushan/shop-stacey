package com.stacey.shop.util;

import com.stacey.shop.entity.User;
import com.stacey.shop.inter.IUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/19.
 */
public class MysqlJdbcRealM extends JdbcRealm {
    @Resource
    private IUser iUser;

    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = String.valueOf(usernamePasswordToken.getUsername());
        User user = iUser.getUserById(1);
//        User user = userService.findByUserName(usernamee);
        AuthenticationInfo authenticationInfo = null;
        if (null != user) {
            String password = new String(usernamePasswordToken.getPassword());
            if (password.equals(user.getPassword())) {
                authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            }
        }
        return authenticationInfo;
    }

    //授权
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//
//        String username = (String) principals.getPrimaryPrincipal();
//        if (!Strings.isNullOrEmpty(username)) {
//            SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
//            authenticationInfo.setRoles(userService.findRolesStr(username));
//            authenticationInfo.setStringPermissions(userService.findPermissionsStr(username));
//            return authenticationInfo;
//        }
//        return null;
//
//    }
}
