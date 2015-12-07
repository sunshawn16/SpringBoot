package com.tw.school.service;

import com.tw.school.repository.StudentRepository;
import com.tw.school.model.Student;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created by xiaosun on 12/6/15.
 */
public class SearchStudentServiceImplTest {

    private SearchStudentServiceImpl searchStudentService;
    private StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception {
        searchStudentService = new SearchStudentServiceImpl();
        EasyMockSupport easyMockSupport = new EasyMockSupport();
        studentRepository = easyMockSupport.createMock(StudentRepository.class);
        setField(searchStudentService, "studentRepository", studentRepository);
    }

    @Test
    public void shouldReturnZhangWhenSearchZhangGivenZhang() throws Exception {
        Student student = new Student("zhang", 1, 22, "asodi");
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        expect(studentRepository.findAll()).andReturn(students);

        replay(studentRepository);
        List<Student> result = searchStudentService.searchStudentByName("zhang");
        verify(studentRepository);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("zhang"));

    }

    @Test
    public void shouldReturnEmptyListWhenSearchSunGivenZhang() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("Zhang", 2, 25, "erfdgd");
        students.add(student);
        expect(studentRepository.findAll()).andReturn(students);

        replay(studentRepository);
        List<Student> result = searchStudentService.searchStudentByName("Sun");
        verify(studentRepository);

        assertThat(result.size(), is(0));
    }

    @Test
    public void shouldReturnShenZhangWhenSearchZhangGivenShenZhang() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("shenzhang", 3, 29, "asa");
        students.add(student);
        expect(studentRepository.findAll()).andReturn(students);

        replay(studentRepository);
        List<Student> result = searchStudentService.searchStudentByName("zhang");
        verify(studentRepository);
        assertThat(result.size(),is(1));
        assertThat(result.get(0).getName(),is("shenzhang"));
    }

    @Test
    public void shouldReturnZhangWhenSearchzhangGivenZhang() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("Zhang", 1, 22, "chengdu");
        students.add(student);
        expect(studentRepository.findAll()).andReturn(students);

        replay(studentRepository);
        List<Student> result = searchStudentService.searchStudentByName("zhang");
        verify(studentRepository);

        assertThat(result.size(),is(1));
        assertThat(result.get(0).getName(),is("Zhang"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnErrorWhenSearchNullGivenZhang() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student("zhang", 1, 23, "chengdu");
        students.add(student);
        expect(studentRepository.findAll()).andReturn(students);

        replay(studentRepository);
        searchStudentService.searchStudentByName(null);
        verify(studentRepository);

    }
}