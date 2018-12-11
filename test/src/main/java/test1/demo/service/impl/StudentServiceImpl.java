package test1.demo.service.impl;

import org.springframework.stereotype.Service;
import test1.demo.model.Student;
import test1.demo.repositories.StudentRepository;
import test1.demo.repositories.StudyProgramRepository;
import test1.demo.service.StudentService;

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
    public Optional<Student> getStudentByIndex(String index) {
        return studentRepository.findById(index);
    }

    @Override
    public List<Student> getStudyProgramStudents(Long index) {

        List<Student> students = (List<Student>) studentRepository.findAll();

        return students
                .stream()
                .filter(s -> s.getStudyPrograms().getId().equals(index))
                .collect(Collectors.toList());
    }

    @Override
    public Student addNew(Student student) {
        return studentRepository.save(student);
    }

//    @Override
//    public void delete(String index) {
//        studentRepository.delete(studentRepository.findById(index));
//    }


}
