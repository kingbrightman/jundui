package org.yxm.jundui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yxm.jundui.model.TestValidation;

import javax.validation.Valid;

/**
 * Created by yxm on 2016.11.23.
 */
@Controller
@RequestMapping("/test")
public class TestValidationController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new TestValidation());
        return "test/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid TestValidation testValidation, BindingResult br) {
        if (br.hasErrors()) {
            return "test/add";
        }

        System.out.println("name:" + testValidation.getName());
        System.out.println("email:" + testValidation.getEmail());

        return "test/success";
    }


}
