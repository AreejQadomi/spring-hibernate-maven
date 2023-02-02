package com.springdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

    // Controller method to show initial formb
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Controller method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // new method to read from data and add data to the model
    @RequestMapping("/sillyRequest")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        //read the request param from the Html form
        String name = request.getParameter("studentName");

        //convert the data to all caps and create the msg
        name = "Yo! " + name.toUpperCase();

        //add the msg to the model
        model.addAttribute("name", name);

        // return to view
        return "helloworld";
    }

    @RequestMapping("/sillyRequest2")
    public String letsShoutDude2(@RequestParam String studentName, Model model) {
        //convert the data to all caps and create the msg
        studentName = "Yo! " + studentName.toUpperCase();

        //add the msg to the model
        model.addAttribute("studentName", studentName);

        // return to view
        return "helloworld";
    }

}
