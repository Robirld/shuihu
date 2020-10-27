package com.shuihu.boss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author user
 * @Date 2020/10/26 10:36 上午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String dish_name;
    private Integer category;
    private BigDecimal origin_price;
    private BigDecimal current_price;
    private String unit;
    private Integer quantity;
    private String img_path;
    private String description;
    private Boolean deleted;
    private Date create_at;
}
