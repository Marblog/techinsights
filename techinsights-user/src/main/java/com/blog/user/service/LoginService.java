package com.blog.user.service;

import com.blog.user.utils.ResponseResult;
import com.blog.user.entity.User;

public interface LoginService {
    ResponseResult login(User user);
}
