package com.martin.studentsapi.studentsapi.services;

import com.martin.studentsapi.studentsapi.models.Student;
import com.martin.studentsapi.studentsapi.models.exceptions.IndexException;
import com.martin.studentsapi.studentsapi.models.exceptions.MissingParameterException;
import com.martin.studentsapi.studentsapi.models.exceptions.StudentNotFoundException;
import com.martin.studentsapi.studentsapi.models.exceptions.StudyProgramNotFoundException;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface StudentService {

    List<Student> getAllStudents();

    Student addNew(String index, String name, String lastName, String studyProgramName) throws MissingParameterException, IndexException, StudyProgramNotFoundException;

    Student deleteStudent(String index) throws StudentNotFoundException;

    Student getStudentByIndex(String index);

    Student updateStudent(String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException;

    List<Student> getAllStudentsByStudyProgram(Long index);

}
