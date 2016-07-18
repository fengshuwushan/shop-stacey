package com.stacey.shop.controller;

import com.stacey.shop.entity.User;
import com.stacey.shop.entity.UserRole;
import com.stacey.shop.inter.IUser;
import com.stacey.shop.inter.IUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUser iUser;

    @RequestMapping("/userList")
    public ModelAndView listAll(HttpServletRequest request, HttpServletResponse response)
    {
        User user = iUser.getUserById(1);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        System.out.println("user");
        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("userList", userList);
        //modelAndView.addObject("password", user.getPassword());
        return modelAndView;
    }
}
