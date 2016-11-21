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
        model.addAttribute("groups", groupService.list());
        return "group/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated Group group, BindingResult br) {
        if (br.hasErrors()) {
            return "group/edit";
        }
        groupService.add(group);
        return "redirect:/admin/group/groups";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(groupService.load(id));
        model.addAttribute("groups", groupService.list());
        return "group/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Validated Group group, BindingResult br) {
        if (br.hasErrors()) {
            return "group/edit";
        }
        Group g = groupService.load(id);
        g.setDescription(group.getDescription());
        g.setName(group.getName());
        g.setParent(group.getParent());
        groupService.update(g);
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
