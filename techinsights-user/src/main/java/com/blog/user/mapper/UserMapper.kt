package com.blog.user.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.blog.user.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper :BaseMapper<User>{
}