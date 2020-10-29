package com.shuihu.innermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author user
 * @Date 2020/10/29 3:59 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;
    private String code;
    private String name;
    private String url;
    private String description;
}
