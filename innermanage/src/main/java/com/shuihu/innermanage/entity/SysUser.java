package com.shuihu.innermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author user
 * @Date 2020/10/29 2:53 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private String real_name;
    private Integer age;
    private String phone;
    private Boolean gender;
    private String address;
    private Date add_time;
    private List<SysRole> roles;
}
