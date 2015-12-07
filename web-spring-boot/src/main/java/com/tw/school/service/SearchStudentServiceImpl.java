package com.tw.school.service;

import com.tw.school.repository.StudentRepository;
import com.tw.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang.StringUtils.containsIgnoreCase;


@Service
public class SearchStudentServiceImpl implements SearchStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> searchStudentByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        } else {
            ArrayList<Student> students = newArrayList(studentRepository.findAll());
            return getAllStudentsWithNameContains(name, students);
        }
    }

    private List<Student> getAllStudentsWithNameContains(String name, List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (containsIgnoreCase(student.getName(), name)) {
                result.add(student);
            }
        }
        return result;
    }
}
