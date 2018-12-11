package test1.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import test1.demo.model.Student;
import test1.demo.model.StudyProgram;
import test1.demo.repositories.StudentRepository;
import test1.demo.repositories.StudyProgramRepository;


/**
 * Created by @kmartin62
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private StudentRepository studentRepository;
    private StudyProgramRepository studyProgramRepository;

    public DevBootstrap(StudentRepository studentRepository, StudyProgramRepository studyProgramRepository) {
        this.studentRepository = studentRepository;
        this.studyProgramRepository = studyProgramRepository;
    }

    private void initData(){


        StudyProgram studyProgram = new StudyProgram();
        studyProgram.setName("KNI");
        StudyProgram studyProgram1 = new StudyProgram();
        studyProgram1.setName("IKI");

        Student student = new Student();
        student.setIndex("161159");
        student.setName("Martin");
        student.setLastName("Kostadinov");
        student.setStudyPrograms(studyProgram);

        studentRepository.save(student);

        studyProgramRepository.save(studyProgram);
        studyProgramRepository.save(studyProgram1);

    }




}
