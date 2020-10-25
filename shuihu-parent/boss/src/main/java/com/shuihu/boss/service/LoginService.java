package com.shuihu.boss.service;

import com.shuihu.boss.entity.User;

public interface LoginService {
    User identify(User user);

    void saveUser(User user);
}
