package com.shuihu.innermanage.service.impl;

import com.shuihu.innermanage.dao.SysUserDao;
import com.shuihu.innermanage.entity.SysPermission;
import com.shuihu.innermanage.entity.SysRole;
import com.shuihu.innermanage.entity.SysUser;
import com.shuihu.innermanage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/29 5:12 下午
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Cacheable(cacheNames = "authority", key = "#username")
    public SysUser getUserByUsername(String username) {
        SysUser user = userDao.getUserByUsername(username);
        if (user != null){
            List<SysRole> roles = userDao.getRoleByUserId(user.getId());
            if (roles == null){
                throw new RuntimeException("登陆用户无角色错误");
            }
            user.setRoles(roles);
            for (SysRole role : roles){
                List<SysPermission> permissionByRoleId = userDao.getPermissionByRoleId(role.getId());
                role.setPermissions(permissionByRoleId);
            }
        }
        return user;
    }

    @Override
    public void addUser(SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    public void addRole(SysRole role) {
        userDao.addRole(role);
    }

    @Override
    public void addPermission(SysPermission permission) {
        userDao.addPermission(permission);
    }

    @Override
    public void addRole2User(Integer userId, List<Integer> roleIds) {
        userDao.addRole2User(userId, roleIds);
    }

    @Override
    public void addPermission2Role(Integer roleId, List<Integer> permissionIds) {
        userDao.addPermission2Role(roleId, permissionIds);
    }

    @Override
    public List<SysRole> getAllRole() {
        return userDao.getAllRole();
    }

    @Override
    public List<SysPermission> getAllPermission() {
        return userDao.getAllPermission();
    }
}
