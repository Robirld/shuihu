package com.shuihu.innermanage.service;

import com.shuihu.innermanage.entity.SysPermission;
import com.shuihu.innermanage.entity.SysRole;
import com.shuihu.innermanage.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/29 4:52 下午
 * @Version 1.0
 */
public interface SysUserService {
    SysUser getUserByUsername(String username);
    void addUser(SysUser user);
    void addRole(SysRole role);
    void addPermission(SysPermission permission);
    void addRole2User(Integer userId, List<Integer> roleIds);
    void addPermission2Role(Integer roleId, List<Integer> permissionIds);
    List<SysRole> getAllRole();
    List<SysPermission> getAllPermission();
}
