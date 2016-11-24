package org.yxm.jundui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.Train;
import org.yxm.jundui.model.User;
import org.yxm.jundui.service.ITrainService;
import org.yxm.jundui.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by yxm on 2016.11.24.
 */
@Controller
@RequestMapping("/admin/train")
public class TrainController {

    @Autowired
    ITrainService trainService;

    @Autowired
    IUserService userService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datas", trainService.find());
        return "train/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Train());
        return "train/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Train train, BindingResult br, Model model, HttpServletRequest request) {
        if (br.hasErrors()) {
            return "train/edit";
        }

        User loginUser = (User) request.getSession().getAttribute("login_user");
        if (loginUser == null) {
            loginUser = userService.load(2);
        }
        train.setCreateUser(loginUser);
        train.setCreateDate(new Date());

        trainService.add(train);
        return "redirect:/admin/train/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        //TODO:提示删除train，那么train的所有项目成绩都会删除

        trainService.delete(id);
        return "redirect:/admin/train/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Train train = trainService.load(id);
        model.addAttribute(train);
        return "train/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid Train train, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "train/edit";
        }

        Train oldTrain = trainService.load(id);
        oldTrain.setName(train.getName());
        oldTrain.setDescription(train.getDescription());
        trainService.update(oldTrain);
        return "redirect:/admin/train/list";
    }


}
