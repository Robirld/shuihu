package com.shuihu.boss.dao;

import com.shuihu.boss.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserByUname(@Param("login_name") String loginName);

    void save(User user);
}
