package test1.demo.service.impl;

import org.springframework.stereotype.Service;
import test1.demo.model.Student;
import test1.demo.model.StudyProgram;
import test1.demo.model.exceptions.EmptyParameteresException;
import test1.demo.model.exceptions.IndexNotSixException;
import test1.demo.model.exceptions.StudentNotFoundException;
import test1.demo.model.exceptions.StudyProgramNotFound;
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
    public Student addNew(String index, String name, String lastName, String studyProgramName) throws StudyProgramNotFound, EmptyParameteresException, IndexNotSixException {

        if(index == null || name == null || lastName == null || studyProgramName == null) {
            throw new EmptyParameteresException();
        }

        if(index.toCharArray().length != 6) {
            throw new IndexNotSixException();
        }
        try {
            Integer.parseInt(index);
        }
        catch(NumberFormatException ex){
            throw new IndexNotSixException();
        }

        List<StudyProgram> studyPrograms = (List<StudyProgram>) studyProgramRepository.findAll();

        if(!studyPrograms.stream().anyMatch(s -> s.getName().equals(studyProgramName))){
            throw new StudyProgramNotFound();
        }

        Student student = new Student();
        student.setIndex(index);
        student.setName(name);
        student.setLastName(lastName);
        student.setStudyPrograms((StudyProgram) studyPrograms.stream().filter(s -> s.getName().equals(studyProgramName)));

        return studentRepository.save(student);
    }

    @Override
    public Student update(String index, String name, String lastName, String studyProgramName) throws StudentNotFoundException, StudyProgramNotFound {

        Optional<Student> student = studentRepository.findById(index);

        if(!student.isPresent()){
            throw new StudentNotFoundException();
        }

        student.get().setName(name);
        student.get().setLastName(lastName);

        List<StudyProgram> studyPrograms = (List<StudyProgram>) studyProgramRepository.findAll();

        if(!studyPrograms.stream().anyMatch(s -> s.getName().equals(studyProgramName))){
            throw new StudyProgramNotFound();
        }

        Optional<StudyProgram> studyProgram = studyPrograms.stream().filter(s -> s.getName().equals(studyProgramName)).findAny();

        student.get().setStudyPrograms(studyProgram.get());


        return studentRepository.save(student.get());
    }

//    @Override
//    public Student addNew(Student student) {
//
//        return studentRepository.save(student);
//    }

//    @Override
//    public void delete(String index) {
//        studentRepository.delete(studentRepository.findById(index));
//    }


}
