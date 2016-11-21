package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.IUserService;
import org.yxm.jundui.service.UserService;

/**
 * Created by yxm on 2016.11.15.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/users")
    public String list(Model model) {
        model.addAttribute("datas", userService.find());
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        return "user/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated User user, BindingResult br) {
        if (br.hasErrors()) {
            return "user/edit";
        }
        userService.add(user);

        //TODO: 修改group和role
        return "redirect:/admin/user/users";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/admin/user/users";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(userService.load(id));
        return "user/edit";
    }

    public String update(@PathVariable int id, @Validated User user, BindingResult br) {
        if (br.hasErrors()) {
            return "user/edit";
        }
        User u = userService.load(id);
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setSex(user.getSex());
        u.setUsername(user.getUsername());

        //TODO: 修改group和role
        return "redirect:/admin/user/users";
    }

}
