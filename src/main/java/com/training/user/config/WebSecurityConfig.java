//package com.training.user.config;
//
//import com.training.user.modules.user.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return  bCryptPasswordEncoder;
//    }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        //api for guest
//        http.authorizeRequests().antMatchers("/","/login","/logout").permitAll();
//
//        // api required log,role is user or admin
//        http.authorizeRequests().antMatchers("/userinfo").access("hasAnyRole('ADMIN','USER')");
//
//        //api for admin only
//        http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
//
//        //handle exception for authorization
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//
//    }
//}
