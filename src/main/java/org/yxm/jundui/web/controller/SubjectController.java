package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.SubjectType;
import org.yxm.jundui.service.ISubjectService;
import org.yxm.jundui.util.EnumUtils;

import javax.validation.Valid;

/**
 * Created by yxm on 2016.11.23.
 */
@Controller
@RequestMapping("/admin/subject")
public class SubjectController {

    @Autowired
    ISubjectService subjectService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datas", subjectService.find());
        return "subject/list";
    }

    private void initAdd(Model model) {
        model.addAttribute("types", EnumUtils.enumProp2NameMap(SubjectType.class, "name"));
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Subject());
        initAdd(model);
        return "subject/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Subject subject, BindingResult br, Model model) {
        if (br.hasErrors()) {
            initAdd(model);
            return "subject/edit";
        }

        subjectService.add(subject);
        return "redirect:/admin/subject/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        // TODO:如果项目还有被使用，则不能删除
        subjectService.delete(id);
        return "redirect:/admin/subject/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Subject subject = subjectService.load(id);
        model.addAttribute(subject);
        initAdd(model);
        return "subject/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid Subject subject, BindingResult br, Model model) {
        if (br.hasErrors()) {
            initAdd(model);
            return "subject/edit";
        }

        Subject oldSubject = subjectService.load(id);
        oldSubject.setName(subject.getName());
        oldSubject.setDescription(subject.getDescription());
        oldSubject.setType(subject.getType());

        subjectService.update(oldSubject);
        return "redirect:/admin/subject/list";
    }
}
