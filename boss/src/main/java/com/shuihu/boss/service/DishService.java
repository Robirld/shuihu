package com.shuihu.boss.service;

import com.shuihu.boss.entity.Dish;
import com.shuihu.boss.entity.Page;

/**
 * @Author user
 * @Date 2020/10/26 11:02 上午
 * @Version 1.0
 */
public interface DishService {
    Page<Dish> getDishes(Integer category, Page<Dish> page);
}
