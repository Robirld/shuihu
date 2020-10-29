package com.shuihu.innermanage.service;

import com.shuihu.innermanage.entity.SysPermission;
import com.shuihu.innermanage.entity.SysRole;
import com.shuihu.innermanage.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author user
 * @Date 2020/10/29 5:09 下午
 * @Version 1.0
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    SysUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUserByUsername(s);
        if (null == sysUser){
            throw new UsernameNotFoundException(s);
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : sysUser.getRoles()){
            for (SysPermission permission : role.getPermissions()){
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }
        return new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
    }
}
