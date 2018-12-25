package com.martin.studentsapi.studentsapi.controllers;

import com.martin.studentsapi.studentsapi.models.Student;
import com.martin.studentsapi.studentsapi.models.dto.StudentDto;
import com.martin.studentsapi.studentsapi.models.exceptions.IndexException;
import com.martin.studentsapi.studentsapi.models.exceptions.MissingParameterException;
import com.martin.studentsapi.studentsapi.models.exceptions.StudentNotFoundException;
import com.martin.studentsapi.studentsapi.models.exceptions.StudyProgramNotFoundException;
import com.martin.studentsapi.studentsapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by @kmartin62
 */

@CrossOrigin({"*"})
@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return getStudents();
    }


    @GetMapping("/{index}")
    public Student getStudentByIndex(@PathVariable("index") String index){
        return studentService.getStudentByIndex(index);
    }

    @GetMapping("/by_study_program/{index}")
    public List<Student> getStudentsByStudyProgram(@PathVariable("index") Long index){
        return studentService.getAllStudentsByStudyProgram(index);
    }

    @PatchMapping("/{index}")
    public void updateStudent(@PathVariable("index") String index, @RequestBody StudentDto student) throws StudentNotFoundException {
            studentService.updateStudent(index,
                    student.getName(),
                    student.getLastName(),
                    student.getStudyProgram());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody StudentDto student) throws MissingParameterException, StudyProgramNotFoundException, IndexException {
        studentService.addNew(student.getIndex(),
                student.getName(),
                student.getLastName(),
                student.getStudyProgram());
    }

    @DeleteMapping("/{index}")
    public void deleteStudent(@PathVariable("index") String index) throws StudentNotFoundException {
        studentService.deleteStudent(index);
    }
}
