package com.tw.school.controller;

import com.tw.school.repository.StudentRepository;
import com.tw.school.service.SearchStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/ui")
public class UIController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SearchStudentService searchStudentService;

    @RequestMapping(value = "/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "listOfStudent";
    }
    @RequestMapping(value = "/students",method = POST)
    public String getAllStudents(@RequestParam("name") String name, Model model) {
        model.addAttribute("students", searchStudentService.searchStudentByName(name));
        return "listOfStudent";
    }

}
