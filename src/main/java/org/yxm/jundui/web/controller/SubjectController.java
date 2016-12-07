package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.exception.CmsException;
import org.yxm.jundui.model.GradeLevel;
import org.yxm.jundui.model.Subject;
import org.yxm.jundui.model.SubjectType;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.service.GradeLevelService;
import org.yxm.jundui.service.SubjectService;
import org.yxm.jundui.util.EnumUtils;
import org.yxm.jundui.web.dto.SubjectDto;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by yxm on 2016.11.23.
 */
@Controller
@RequestMapping("/admin/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;
    @Autowired
    GradeLevelService gradeLevelService;

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
        model.addAttribute(new SubjectDto());
        initAdd(model);
        return "subject/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid SubjectDto subjectDto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            initAdd(model);
            return "subject/edit";
        }

        subjectService.add(subjectDto.getSubject());
        return "redirect:/admin/subject/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        // TODO:如果项目还有被使用，则不能删除
        List<Train> trains = subjectService.listSubjectTrains(id);
        if (trains != null && trains.size() > 0) {
            throw new CmsException("有训练包含了该项目，请先取消使用了该项目的训练再删除");
        }

        subjectService.delete(id);
        return "redirect:/admin/subject/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Subject subject = subjectService.load(id);
        GradeLevel gradeLevel = gradeLevelService.load(id);
        if (gradeLevel == null) {
            gradeLevel = new GradeLevel();
        }
        SubjectDto subjectDto = new SubjectDto(subject, gradeLevel);

        model.addAttribute(subjectDto);
        initAdd(model);
        return "subject/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid SubjectDto subjectDto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            initAdd(model);
            return "subject/edit";
        }

        Subject oldSubject = subjectService.load(id);
        Subject newSubject = subjectDto.getSubject();

        oldSubject.setName(newSubject.getName());
        oldSubject.setDescription(newSubject.getDescription());
        oldSubject.setType(newSubject.getType());

        GradeLevel oldLevel = oldSubject.getLevel();
        if (oldLevel == null) {
            oldLevel = new GradeLevel();
        }
        GradeLevel newLevel = newSubject.getLevel();
        oldLevel.setYfrom(newLevel.getYfrom());
        oldLevel.setYto(newLevel.getYto());
        oldLevel.setLfrom(newLevel.getLfrom());
        oldLevel.setLto(newLevel.getLto());
        oldLevel.setZfrom(newLevel.getZfrom());
        oldLevel.setZto(newLevel.getZto());
        oldLevel.setCfrom(newLevel.getCfrom());
        oldLevel.setCto(newLevel.getCto());

        oldSubject.setLevel(oldLevel);
        subjectService.update(oldSubject);
        return "redirect:/admin/subject/list";
    }
}
