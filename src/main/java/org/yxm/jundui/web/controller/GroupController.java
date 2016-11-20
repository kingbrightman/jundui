package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.service.IGroupService;
import org.yxm.jundui.service.IUserService;

/**
 * Created by yxm on 2016.11.20.
 */
@Controller
@RequestMapping("/admin/group")
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/groups")
    public String list(Model model) {
        model.addAttribute("datas", groupService.find());
        return "group/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Group());
        return "group/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated Group group, BindingResult br) {
        if (br.hasErrors()) {
            System.out.println(br.getErrorCount());
            return "group/add";
        }
        System.out.println("add success");
        groupService.add(group);
        return "redirect:/admin/group/groups";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(groupService.load(id));
        return "group/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Validated Group group, BindingResult br) {
        if (br.hasErrors()) {
            return "group/update";
        }
        Group ug = groupService.load(id);
        ug.setDescription(group.getDescription());
        ug.setName(group.getName());
        groupService.update(ug);
        return "redirect:/admin/group/groups";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        groupService.delete(id);
        return "redirect:/admin/group/groups";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute(groupService.load(id));
        model.addAttribute("us", groupService.listGroupUsers(id));
        return "group/show";
    }

    @RequestMapping("/clearUsers/{id}")
    public String clearGroupUsers(@PathVariable int id) {
        groupService.deleteGroupUsers(id);
        return "redirect:/admin/group/groups";
    }
}
