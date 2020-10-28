package com.shuihu.boss.controller;

import com.shuihu.boss.entity.CommonResponse;
import com.shuihu.boss.entity.Dish;
import com.shuihu.boss.entity.Page;
import com.shuihu.boss.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/26 10:59 上午
 * @Version 1.0
 */
@Controller
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping("/dishList")
    @ResponseBody
    CommonResponse<Page<Dish>> dishList(@RequestParam("category") Integer category, Page<Dish> page){
        try {
            Page<Dish> dishPage = dishService.getDishes(category, page);
            if (dishPage == null || dishPage.getContent() == null){
                return new CommonResponse<>(500, "未找到菜单", null);
            }
            return new CommonResponse<>(200, "success", dishPage);
        }catch (Exception e){
            log.error("获取菜单异常:{}", e.getMessage());
            return new CommonResponse<>(500, "获取菜单异常", null);
        }
    }

    @GetMapping("dishList")
    String dishesPage(){
        return "dishList";
    }
}
