package com.blog.user.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.util.Date

data class User(
    @TableId(type = IdType.AUTO)
    var userId: Long?,
    val username: String,
    val emailAddress: String,
    val passwordHash: String,
    val permissions: String, // 可能需要更具体的类型
    val firstName: String,
    val lastName: String,
    val birthday: Date, // 使用 Date 类型表示生日
    val avatarUrl: String,
    val biography: String,
    val registrationDate: Date,
    val lastLoginTime: Date,
    val accountStatus: String, // 可能需要更具体的类型
    val resetToken: String
)

