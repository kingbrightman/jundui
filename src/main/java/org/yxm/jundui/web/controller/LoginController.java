package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yxm.jundui.base.Constants;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.IUserService;
import org.yxm.jundui.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2016.12.05.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "main/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request) {

        User user = userService.loadByUserName(username);
        if (user == null) {
            request.setAttribute(Constants.ERROR_INFO, "用户不存在");
            return "main/login";
        }

        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute(Constants.LOGIN_USER, user);
            return "redirect:/admin/main/index";
        }

        request.setAttribute(Constants.ERROR_INFO, "用户名或密码错误");
        return "main/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.LOGIN_USER);
        return "redirect:/admin/main/index";
    }
}
