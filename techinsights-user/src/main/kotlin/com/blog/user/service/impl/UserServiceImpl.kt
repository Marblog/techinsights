package com.blog.user.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.blog.user.entity.User
import com.blog.user.mapper.UserMapper
import com.blog.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : ServiceImpl<UserMapper, User>(), UserService
