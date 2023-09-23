package com.blog.user.service.impl;

import com.blog.user.entity.User;
import com.blog.user.service.LoginService;
import com.blog.user.utils.JwtUtil;
import com.blog.user.utils.RedisCache;
import com.blog.user.utils.ResponseResult;
import com.blog.user.pojo.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPasswordHash());
        long startTime = System.currentTimeMillis(); // 记录方法开始时间
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        long endTime = System.currentTimeMillis(); // 记录方法结束时间
        long executionTime = endTime - startTime; // 计算方法执行时间
        logger.info("Authentication认证时间: {} ms", executionTime);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

}
