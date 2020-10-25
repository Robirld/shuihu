package com.shuihu.boss.service.impl;

import com.shuihu.boss.dao.UserDao;
import com.shuihu.boss.entity.User;
import com.shuihu.boss.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;
    @Override
    public User identify(User user) {
        User userByUname = userDao.getUserByUname(user.getLogin_name());
        if (userByUname.getPassword().equals(user.getPassword())) {
            log.info("登录用户：{}", userByUname);
            return userByUname;
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        log.info("注册新用户：{}", user);
        userDao.save(user);
    }
}
