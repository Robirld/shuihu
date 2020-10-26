package com.shuihu.boss.service;

import com.shuihu.boss.entity.Dish;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/26 11:02 上午
 * @Version 1.0
 */
public interface DishService {
    List<Dish> getDishes(Dish dish);
}
