package org.yxm.jundui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yxm on 2016.11.28.
 */
@Controller
@RequestMapping("/admin/main")
public class MainController {

    @RequestMapping(value = "/index")
    public String index() {
        return "main/index";
    }

    @RequestMapping(value = "/index_left")
    public String left() {
        return "main/index_left";
    }
}
