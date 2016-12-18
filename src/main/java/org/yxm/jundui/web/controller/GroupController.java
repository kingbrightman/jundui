package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.Group;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.GroupService;
import org.yxm.jundui.service.TrainService;
import org.yxm.jundui.service.UserService;

import java.util.List;

/**
 * Created by yxm on 2016.11.20.
 */
@Controller
@RequestMapping("/admin/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainService trainService;

    @RequestMapping("/list")
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
        return "redirect:/admin/group/list";
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
        return "redirect:/admin/group/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        //TODO:如果还有子部门，不能删除
        List<Integer> childIds = groupService.listChildrenIds(id);
        childIds.remove(0 );//删除自己
        if(childIds!=null && childIds.size()>0){
            throw new CmsException("该部门还有子部门，请先删除子部门");
        }
        //TODO:如果还有用户，不能删除
        List<User> users = groupService.listGroupUsers(id);
        if(users!=null && users.size()>0){
            throw new CmsException("该部门下有用户，请先删除用户");
        }

        groupService.delete(id);
        return "redirect:/admin/group/list";
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
        return "redirect:/admin/group/list";
    }
}
