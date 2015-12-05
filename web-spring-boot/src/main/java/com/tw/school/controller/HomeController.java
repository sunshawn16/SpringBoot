package com.tw.school.controller;

import com.google.common.collect.ImmutableList;
import com.tw.school.Repository.StudentRepository;
import com.tw.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
public class HomeController {
    @Autowired
    private StudentRepository studentRepository;
    private List<Student> students = ImmutableList.of(new Student("Zhang", 1, 20, true), new Student("Sun", 2, 24, false));

//    @RequestMapping
//    public String home(@RequestParam(value="name", required=false,defaultValue = "Xiao") String name, Model model){
//
//        model.addAttribute("name", name);
//        return "welcome";
//    }


    @RequestMapping(value = "/students", method = GET)
    public List<Student> getAllStudents() {
        studentRepository.save(students);
        return newArrayList(studentRepository.findAll());
    }
//    @RequestMapping("/createStudent")
//    String createStudent(){
//        return "createStudent";
//    }
//
//    @RequestMapping(value = "/createStudent",method = POST)
//    public String CreateStudent(@ModelAttribute("student")Student student,Model model){
//        studentRepository.save(student);
//        Iterable<Student> students = studentRepository.findAll();
//        model.addAttribute("student", student);
//        return "ListofStudent";
//
//    }

}
