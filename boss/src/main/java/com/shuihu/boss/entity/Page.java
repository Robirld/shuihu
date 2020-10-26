package com.shuihu.boss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author user
 * @Date 2020/10/26 6:46 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> implements Serializable {
    private Integer start;
    private Integer count;
    private Integer totalNum;
    private Integer end;
    private List<T> entities;
}
