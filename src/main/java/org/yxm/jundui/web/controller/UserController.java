package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.dao.UserDao;
import org.yxm.jundui.model.User;
import org.yxm.jundui.model.UserDto;
import org.yxm.jundui.service.IGroupService;
import org.yxm.jundui.service.IRoleService;
import org.yxm.jundui.service.IUserService;

import javax.validation.Valid;

/**
 * Created by yxm on 2016.11.15.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IGroupService groupService;

    @RequestMapping(value = "/users")
    public String list(Model model) {
        model.addAttribute("datas", userService.find());
        return "user/list";
    }

    private void initAdd(Model model) {
        model.addAttribute("roles", roleService.list());
        model.addAttribute("groups", groupService.list());
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("userDto", new UserDto());
        initAdd(model);
        return "user/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid UserDto userDto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            initAdd(model);
            return "user/edit";
        }
        userService.add(userDto.getUser(), userDto.getRoleIds());

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
        User user = userService.load(id);
        UserDto userDto = new UserDto(user, userService.listUserRoleIds(user.getId()));

        model.addAttribute("userDto", userDto);
        initAdd(model);
        return "user/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid UserDto userDto, BindingResult br) {
        if (br.hasErrors()) {
            return "user/edit";
        }

        User oldUser = userService.load(id);
        User newUser = userDto.getUser();

        oldUser.setName(newUser.getName());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setSex(newUser.getSex());
        oldUser.setGroup(newUser.getGroup());

        userService.update(oldUser, userDto.getRoleIds());

        //TODO: 修改group和role
        return "redirect:/admin/user/users";
    }

}
