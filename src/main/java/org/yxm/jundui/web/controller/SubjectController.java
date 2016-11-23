package org.yxm.jundui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yxm on 2016.11.23.
 */
@Controller
@RequestMapping("/admin/subject")
public class SubjectController {

    @RequestMapping("/subjects")
    public String list() {
        return "subject/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "subject/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add() {
        return "redirect:/admin/subject/subjects";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return "redirect:/admin/subject/subjects";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        return "subject/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id) {
        return "redirect:/admin/subject/subjects";
    }
}
