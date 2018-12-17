package com.martin.studentsapi.studentsapi.services;

import com.martin.studentsapi.studentsapi.models.Student;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface StudentService {

    List<Student> getAllStudents();

    Student addNew(String index, String name, String lastName);

    Student deleteStudent(String index);

    Student getStudentByIndex(String index);

    Student updateStudent(String index, String name, String lastName);

    List<Student> getAllStudentsByStudyProgram(Long index);

}
