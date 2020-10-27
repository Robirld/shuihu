package com.shuihu.boss.controller;

import com.shuihu.boss.entity.CommonResponse;
import com.shuihu.boss.entity.User;
import com.shuihu.boss.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/login")
    String loginPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            return "mainPage";
        }
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    CommonResponse<User> login(@RequestBody User user, HttpServletRequest request){
        CommonResponse<User> response = new CommonResponse<>(500, "用户名验证失败", user);
        if ((user = loginService.identify(user)) != null){
            HttpSession session = request.getSession();
            response.setCode(200);
            response.setMsg("success");
            session.setAttribute("user", user);
        }
        return response;
    }

    @GetMapping("/home")
    String mainPage(){ return "mainPage"; }

    @GetMapping("/register")
    String registerPage(){ return "register"; }

    @PostMapping("/register")
    @ResponseBody
    CommonResponse<String> registerUser(@RequestBody User user) {
        if (StringUtils.isBlank(user.getLogin_name()) || StringUtils.isBlank(user.getPassword())){
            return new CommonResponse<>(500, "用户名和密码不能为空", null);
        }
        try {
            loginService.saveUser(user);
            return new CommonResponse<>(200, "success", user.getLogin_name());
        }catch (Exception e){
            log.error("注册用户错误：{}", e.getMessage());
            return new CommonResponse<>(500, e.getMessage(), null);
        }
    }
}
