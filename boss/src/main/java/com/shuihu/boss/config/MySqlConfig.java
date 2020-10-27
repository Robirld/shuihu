package com.shuihu.boss.config;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author user
 * @Date 2020/10/27 8:47 下午
 * @Version 1.0
 */
@Configuration
public class MySqlConfig {
    @Bean
    public Interceptor myInterceptor(){
        return new MySqlIntercepor();
    }
}
