package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.Role;
import org.yxm.jundui.model.RoleType;
import org.yxm.jundui.service.IRoleService;
import org.yxm.jundui.util.EnumUtils;

/**
 * Created by yxm on 2016.11.20.
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datas", roleService.find());
        return "role/list";
    }

    private void addRoletypesToModel(Model model) {
        model.addAttribute("types", EnumUtils.enumProp2NameMap(RoleType.class, "name"));
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("role", new Role());
        addRoletypesToModel(model);
        return "role/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated Role role, BindingResult br) {
        if (br.hasErrors()) {
            return "role/edit";
        }
        roleService.add(role);
        return "redirect:/admin/role/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        roleService.delete(id);
        return "redirect:/admin/role/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        model.addAttribute(roleService.load(id));
        addRoletypesToModel(model);
        return "role/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Validated Role role, BindingResult br) {
        if (br.hasErrors()) {
            return "role/edit";
        }
        Role r = roleService.load(id);
        r.setName(role.getName());
        r.setDescription(role.getDescription());
        r.setType(role.getType());
        roleService.update(r);
        return "redirect:/admin/role/list";
    }

}
