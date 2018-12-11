package test1.demo.service;

import test1.demo.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentByIndex(String index);

    List<Student> getStudyProgramStudents(Long index);

    Student addNew(Student student);

//    void delete(String index);

}
