package test1.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test1.demo.model.Student;
import test1.demo.model.exceptions.EmptyParameteresException;
import test1.demo.model.exceptions.IndexNotSixException;
import test1.demo.model.exceptions.StudentNotFoundException;
import test1.demo.model.exceptions.StudyProgramNotFound;
import test1.demo.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
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
    public Optional getStudentByIndex(@PathVariable("index") String index){
        return studentService.getStudentByIndex(index);
    }

    @GetMapping("/by_study_program/{id}")
    public List<Student> getStudyProgramStudents(@PathVariable("id") Long index){
        return studentService.getStudyProgramStudents(index);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody Map<String, String> t, HttpServletResponse response) throws StudyProgramNotFound, IndexNotSixException, EmptyParameteresException {
        Student student1 = studentService.addNew(t.get("index"), t.get("name"), t.get("lastName"), t.get("studyProgramName"));
        response.setHeader("Location", "/students/" + student1.getIndex());
    }

    @PatchMapping
    public void updateStudent(String index, String name, String lastName, String studyProgramName) throws StudyProgramNotFound, StudentNotFoundException {
        studentService.update(index, name, lastName, studyProgramName);
    }

//    @DeleteMapping("/{index}")
//    public void delete(@PathVariable String index){
//        studentService.delete(index);
//    }
}
