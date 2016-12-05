package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yxm.jundui.base.Constants;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2016.11.28.
 */
@Controller
@RequestMapping("/admin/main")
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        return "main/index";
    }

    @RequestMapping(value = "/index_left")
    public String left() {
        return "main/index_left";
    }


    private User getLoginUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(Constants.LOGIN_USER);
    }
}
