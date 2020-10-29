package com.shuihu.innermanage.controller;

import com.shuihu.innermanage.entity.SysUser;
import com.shuihu.innermanage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author user
 * @Date 2020/10/29 6:04 下午
 * @Version 1.0
 */
@Controller
public class LoginController {
    @Autowired
    SysUserService userService;

    @GetMapping("/sign/in")
    String signInPage(){
        return "loginPage";
    }

    @GetMapping("/home")
    String home(SysUser user, Model model){
        return "home";
    }

    @GetMapping("/sign/error")
    String signError(Model model){
        model.addAttribute("msg", "error");
        return "loginPage";
    }

    @GetMapping("/sign/up")
    String signUpPage(){
        return "signUp";
    }

    @PostMapping("sign/up/submit")
    String signUpSubmit(SysUser user, Model model){
        try {
            userService.addUser(user);
        } catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "signUp";
        }
        return "loginPage";
    }

    @PreAuthorize("hasAuthority('sys:edit:role')")
    @GetMapping("/sys/role/addPage")
    String addRolePage(){
        return "addRole";
    }

    @PreAuthorize("hasAuthority('sys:edit:permission')")
    @GetMapping("sys/permission/addPage")
    String addPermissionPage(){
        return "addPermission";
    }
}
