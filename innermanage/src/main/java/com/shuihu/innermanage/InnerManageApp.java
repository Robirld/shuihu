package com.shuihu.innermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.shuihu.innermanage.dao"})
public class InnerManageApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(InnerManageApp.class, args);
    }
}
