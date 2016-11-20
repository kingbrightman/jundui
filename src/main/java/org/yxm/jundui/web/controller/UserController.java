package org.yxm.jundui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yxm on 2016.11.15.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/page")
    public String add() {
        return "user";
    }

    @RequestMapping("/userpae")
    public String userPage() {
        return "userpage";
    }


}
