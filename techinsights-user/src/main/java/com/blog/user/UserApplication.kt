package com.blog.user

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
@MapperScan("com.blog.user.mapper")
@SpringBootApplication
class UserApplication

fun main() {
    runApplication<UserApplication>()
}