package com.blog.user.controller;

import com.blog.user.entity.User;
import com.blog.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/java")
    public String java(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        return "java接口";
    }
}
