package com.shuihu.boss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author user
 * @Date 2020/10/26 6:46 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> implements Serializable {

    // 当前页码
    private Integer pageNo = 1;

    // 每页数量
    private Integer pageSize = 10;

    // 记录总数
    private Integer totalRecord;

    // 总页数
    private Integer totalPage;

    // 数据模型
    private List<T> content;

    // 其它参数
    private Map<String, Object> params = new HashMap<>();

}
