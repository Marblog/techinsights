//package com.blog.user.config;
//
//import com.blog.user.mapper.UserMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * TODO 全局的Bean对象提供者
// * @author ss_419
// *
// * @RequiredArgsConstructor --> 代替原本的@Autowired
// */
//@Configuration
//@RequiredArgsConstructor
//public class ApplicationConfig {
//   // 注入数据库操作DAO
//   private final UserMapper repository;
//
//  /**
//   *
//   * @return 用户详细信息  -> jwt身份验证过滤器
//   */
//  @Bean
//  public UserDetailsService userDetailsService() {
//    return username -> repository.findByUserName(username)
//        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//  }
//
//  /**
//   * TODO 四 4.2
//   * @return 身份校验机制、身份验证提供程序
//   */
//  @Bean
//  public AuthenticationProvider authenticationProvider() {
//    // 创建一个用户认证提供者
//    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//    // 设置用户相信信息，可以从数据库中读取、或者缓存、或者配置文件
//    authProvider.setUserDetailsService(userDetailsService());
//    // 设置加密机制，若想要尝试对用户进行身份验证，我们需要知道使用的是什么编码
//    authProvider.setPasswordEncoder(passwordEncoder());
//    return authProvider;
//  }
//
//  /**
//   * TODO 四 4.4 基于用户名和密码或使用用户名和密码进行身份验证
//   * @param config
//   * @return
//   * @throws Exception
//   */
//  @Bean
//  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//    return config.getAuthenticationManager();
//  }
//
//  /**
//   * TODO 四 4.3提供编码机制
//   * @return
//   */
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//}
