package com.shuihu.boss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.shuihu.boss.dao"})
public class BossApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossApplication.class, args);
    }

}
