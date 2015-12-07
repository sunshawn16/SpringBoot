package com.tw.school.controller;

import com.tw.school.repository.StudentRepository;
import com.tw.school.model.Student;
import com.tw.school.service.SearchStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SearchStudentService searchStudentService;

    @RequestMapping(value = "/students", method = GET)
    public List<Student> getAllStudents() {
        return newArrayList(studentRepository.findAll());
    }

    @RequestMapping(value = "/students/{name}", method = GET)
    public List<Student> findStudentByName(@PathVariable String name) {
        return searchStudentService.searchStudentByName(name);
    }


}
