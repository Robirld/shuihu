package com.shuihu.innermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * @Author user
 * @Date 2020/10/29 2:57 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private Integer id;
    private String role_name;
    private List<SysPermission> permissions;
}
