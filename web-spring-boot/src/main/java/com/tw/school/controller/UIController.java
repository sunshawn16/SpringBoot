package com.tw.school.controller;

import com.tw.school.model.Student;
import com.tw.school.repository.StudentRepository;
import com.tw.school.service.CreateStudentService;
import com.tw.school.service.SearchStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UIController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SearchStudentService searchStudentService;
    @Autowired
    CreateStudentService createStudentService;

    @RequestMapping(value = "/welcome")
    public String home() {
        return "welcome";
    }
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }



    @RequestMapping(value = "/createStudent", method = GET)
    public String createStudent(Model model, @ModelAttribute Student student) {
        model.addAttribute("student", new Student());
        return "createStudent";
    }

    @RequestMapping(value = "/createStudent", method = POST)
    public String submitStudent(@ModelAttribute Student student, Model model) {
        createStudentService.create(student);
        model.addAttribute("students", studentRepository.findAll());
        return "listOfStudent";
    }

    @RequestMapping(value = "/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "listOfStudent";
    }

    @RequestMapping(value = "/students", method = GET)
    public String getAllStudents(@RequestParam("name") String name, Model model) {
        model.addAttribute("students", searchStudentService.searchStudentByName(name));
        return "listOfStudent";
    }

}
