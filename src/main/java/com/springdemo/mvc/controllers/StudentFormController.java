package com.springdemo.mvc.controllers;

import com.springdemo.mvc.models.Student;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class StudentFormController {

    // pre-process all web requests coming into our controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        //register binder: for every String class, apply the stringTrimmerEditor
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("showForm")
    public String showForm(Model model) {

        model.addAttribute("studentModel", new Student());

        return "student-form";
    }

    @RequestMapping("processForm")
    public String processForm(@Valid @ModelAttribute("studentModel") Student studentModel,
                              BindingResult bindingResult) {

        //To find out the given error code, in your Spring controller,
        // you can log the details of the binding result
        System.out.println("Binding result: " + bindingResult);

        if (bindingResult.hasErrors()) {
            return "student-form";
        }

        return "student-confirmation";
    }
}
