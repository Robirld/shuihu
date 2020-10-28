package com.shuihu.boss.service.impl;

import com.shuihu.boss.dao.DishDao;
import com.shuihu.boss.entity.Dish;
import com.shuihu.boss.entity.Page;
import com.shuihu.boss.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Page<Dish> getDishes(Integer category, Page<Dish> page) {
        page.setContent(dishDao.getDishes(0D, 110D, category, page));
        return page;
    }
}
