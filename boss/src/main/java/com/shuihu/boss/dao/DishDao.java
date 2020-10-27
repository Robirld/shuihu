package com.shuihu.boss.dao;

import com.shuihu.boss.entity.Dish;
import com.shuihu.boss.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/26 10:47 上午
 * @Version 1.0
 */
@Component
public interface DishDao {
    List<Dish> getDishes(@Param("category") Integer category, @Param("page") Page page);
}
