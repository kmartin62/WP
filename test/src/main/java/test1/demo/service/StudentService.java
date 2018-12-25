package test1.demo.service;

import test1.demo.model.Student;
import test1.demo.model.StudyProgram;
import test1.demo.model.exceptions.EmptyParameteresException;
import test1.demo.model.exceptions.IndexNotSixException;
import test1.demo.model.exceptions.StudentNotFoundException;
import test1.demo.model.exceptions.StudyProgramNotFound;

import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentByIndex(String index);

    List<Student> getStudyProgramStudents(Long index);

    Student addNew(String index, String name, String lastName, String studyProgramName) throws StudyProgramNotFound, EmptyParameteresException, IndexNotSixException;

    Student update(String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException, StudyProgramNotFound;

//    void delete(String index);

}
