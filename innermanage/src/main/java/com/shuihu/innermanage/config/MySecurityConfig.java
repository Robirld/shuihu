package com.shuihu.innermanage.config;

import com.alibaba.fastjson.JSONObject;
import com.shuihu.innermanage.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author user
 * @Date 2020/10/29 4:55 下午
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler((request, response, auth) -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("msg", "success");
                    map.put("code", 200);
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(JSONObject.toJSONString(map));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((request, response, auth) -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("msg", "验证失败");
                    map.put("code", 401);
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(JSONObject.toJSONString(map));
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/sign/**", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
