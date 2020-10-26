package com.shuihu.boss.service.impl;

import com.shuihu.boss.dao.DishDao;
import com.shuihu.boss.entity.Dish;
import com.shuihu.boss.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/26 11:03 上午
 * @Version 1.0
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDao dishDao;
    @Override
    public List<Dish> getDishes(Dish dish) {
        return dishDao.getDishes(dish);
    }
}
