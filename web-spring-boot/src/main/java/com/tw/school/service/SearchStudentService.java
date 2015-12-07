package com.tw.school.service;

import com.tw.school.model.Student;

import java.util.List;

/**
 * Created by xiaosun on 12/6/15.
 */

public interface SearchStudentService {
    List<Student> searchStudentByName(String name);
}
