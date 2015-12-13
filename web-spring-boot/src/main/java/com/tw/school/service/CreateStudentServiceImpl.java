package com.tw.school.service;

import com.tw.school.model.Student;
import com.tw.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentServiceImpl implements CreateStudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }
}
