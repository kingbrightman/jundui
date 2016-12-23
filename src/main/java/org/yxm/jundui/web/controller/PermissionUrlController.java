package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.PermissionUrl;
import org.yxm.jundui.service.PermissionUrlService;

/**
 * Created by yxm on 2016.12.20.
 */
@Controller
@RequestMapping("/admin/permission")
public class PermissionUrlController {

    @Autowired
    private PermissionUrlService permissionUrlService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datas", permissionUrlService.find());
        return "permission/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("permissionUrl", new PermissionUrl());
        return "permission/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated PermissionUrl permissionUrl, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "permission/edit";
        }

        permissionUrlService.add(permissionUrl);
        return "redirect:/admin/permission/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        PermissionUrl permissionUrl = permissionUrlService.load(id);
        model.addAttribute("permissionUrl", permissionUrl);
        return "permission/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Validated PermissionUrl permissionUrl,
                         BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "permission/edit";
        }

        PermissionUrl old = permissionUrlService.load(id);
        old.setUrl(permissionUrl.getUrl());
        old.setDescription(permissionUrl.getDescription());
        permissionUrlService.update(old);
        return "redirect:/admin/permission/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        permissionUrlService.delete(id);
        return "redirect:/admin/permission/list";
    }
}
