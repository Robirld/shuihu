package com.shuihu.boss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String login_name;
    private String password;
    private String name;
    private Integer age;
    private String phone_num;
    private Integer gender;
    private Integer vip = 0;
    private String job;
}
