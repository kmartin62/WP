package com.martin.studentsapi.studentsapi.services.impl;

import com.martin.studentsapi.studentsapi.models.Student;
import com.martin.studentsapi.studentsapi.models.StudyProgram;
import com.martin.studentsapi.studentsapi.repositories.StudentRepository;
import com.martin.studentsapi.studentsapi.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by @kmartin62
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student addNew(String index, String name, String lastName) {
        Student student = new Student();
        student.setIndex(index);
        student.setName(name);
        student.setLastName(lastName);
//        student.setStudyProgram(new StudyProgram(studyProgramName));

        studentRepository.save(student);

        return student;
    }

    @Override
    public Student deleteStudent(String index) {
        List<Student> students = (List<Student>) studentRepository.findAll();

        Optional<Student> student = students
                .stream()
                .filter(s -> s.getIndex().equals(index))
                .findFirst();

        studentRepository.delete(student.get());

        return student.get();
    }

    @Override
    public Student getStudentByIndex(String index) {
        List<Student> students = (List<Student>) studentRepository.findAll();

        Optional<Student> student = students
                .stream()
                .filter(s -> s.getIndex().equals(index))
                .findFirst();

        return student.get();
    }

    @Override
    public Student updateStudent(String index, String name, String lastName) {

        Optional<Student> student = studentRepository.findById(index);

        student.get().setName(name);
        student.get().setLastName(lastName);

        studentRepository.save(student.get());

        return student.get();

    }

    @Override
    public List<Student> getAllStudentsByStudyProgram(Long index) {

        List<Student> students = (List<Student>) studentRepository.findAll();

        return students
                .stream()
                .filter(s -> s.getStudyProgram().getId().equals(index))
                .collect(Collectors.toList());
    }
}
