package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.GroupService;
import org.yxm.jundui.service.RoleService;
import org.yxm.jundui.service.UserService;
import org.yxm.jundui.web.dto.UserDto;

import javax.validation.Valid;

/**
 * Created by yxm on 2016.11.15.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/list")
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
    public String add(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            initAdd(model);
            return "user/edit";
        }
        userService.add(userDto.getUser(), userDto.getRoleIds());

        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        User user = userService.load(id);
        UserDto userDto = new UserDto(user, userService.listUserRoleIds(user.getId()));

        model.addAttribute("userDto", userDto);
        model.addAttribute("isUpdate", true);
        initAdd(model);
        return "user/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid @ModelAttribute("userDto") UserDto userDto, BindingResult br
            , Model model) {
        if (br.hasErrors()) {
            model.addAttribute("isUpdate", true);
            initAdd(model);
            return "user/edit";
        }

        User oldUser = userService.load(id);
        User newUser = userDto.getUser();

        oldUser.setName(newUser.getName());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setSex(newUser.getSex());
        oldUser.setGroup(newUser.getGroup());

        userService.update(oldUser);
        userService.update(oldUser, userDto.getRoleIds());

        return "redirect:/admin/user/list";
    }

}
