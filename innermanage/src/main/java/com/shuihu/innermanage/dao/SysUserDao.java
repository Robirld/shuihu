package com.shuihu.innermanage.dao;

import com.shuihu.innermanage.entity.SysPermission;
import com.shuihu.innermanage.entity.SysRole;
import com.shuihu.innermanage.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author user
 * @Date 2020/10/29 3:10 下午
 * @Version 1.0
 */
@Component
public interface SysUserDao {
    void addUser(SysUser user);
    SysUser getUserByUsername(@Param("username") String username);
    void addRole(SysRole role);
    List<SysRole> getRoleByUserId(@Param("id") Integer id);
    void addPermission(SysPermission permission);
    List<SysPermission> getPermissionByRoleId(@Param("id") Integer id);
    void addRole2User(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);
    void addPermission2Role(@Param("roleId") Integer roleId, @Param("permissionIds") List<Integer> permissionIds);
    List<SysRole> getAllRole();
    List<SysPermission> getAllPermission();
}
