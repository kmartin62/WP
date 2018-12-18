package com.martin.studentsapi.studentsapi.services.impl;

import com.martin.studentsapi.studentsapi.models.Student;
import com.martin.studentsapi.studentsapi.models.StudyProgram;
import com.martin.studentsapi.studentsapi.models.exceptions.IndexException;
import com.martin.studentsapi.studentsapi.models.exceptions.MissingParameterException;
import com.martin.studentsapi.studentsapi.models.exceptions.StudentNotFoundException;
import com.martin.studentsapi.studentsapi.models.exceptions.StudyProgramNotFoundException;
import com.martin.studentsapi.studentsapi.repositories.StudentRepository;
import com.martin.studentsapi.studentsapi.repositories.StudyProgramRepository;
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
    private final StudyProgramRepository studyProgramRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository) {
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student addNew(String index, String name, String lastName, String studyProgramName) throws MissingParameterException, IndexException, StudyProgramNotFoundException {
        Student student = new Student();

        if(index == null || name == null || lastName == null || studyProgramName == null)
            throw new MissingParameterException();

        if(index.length() != 6)
            throw new IndexException();

        List<StudyProgram> studyPrograms = (List<StudyProgram>) studyProgramRepository.findAll();

        Optional<StudyProgram> studyProgram = studyPrograms
                .stream()
                .filter(s -> s.getName().equals(studyProgramName))
                .findAny();

        if(!studyProgram.isPresent())
            throw new StudyProgramNotFoundException();


        student.setIndex(index);
        student.setName(name);
        student.setLastName(lastName);
        student.setStudyProgram(studyProgram.get());

        studentRepository.save(student);

        return student;
    }

    @Override
    public Student deleteStudent(String index) throws StudentNotFoundException {
        List<Student> students = (List<Student>) studentRepository.findAll();

        Optional<Student> student = students
                .stream()
                .filter(s -> s.getIndex().equals(index))
                .findFirst();

        if(!student.isPresent())
            throw new StudentNotFoundException();

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

        if(student.isPresent())
            return student.get();

        return null;
    }

    @Override
    public Student updateStudent(String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException {

        Optional<Student> student = studentRepository.findById(index);

        if(!student.isPresent())
            throw new StudentNotFoundException();

        student.get().setName(name);
        student.get().setLastName(lastName);

        List<StudyProgram> studyPrograms = (List<StudyProgram>) studyProgramRepository.findAll();

        Optional<StudyProgram> studyProgram = studyPrograms.stream().filter(s -> s.getName().equals(studyProgramName)).findFirst();

        if(studyProgram.isPresent()){
            student.get().setStudyProgram(studyProgram.get());
        }
        else {
            throw new StudentNotFoundException();
        }

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
