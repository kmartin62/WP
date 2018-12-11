package test1.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import test1.demo.model.StudyProgram;
import test1.demo.repositories.StudyProgramRepository;
import test1.demo.service.StudyProgramService;

import java.util.List;

/**
 * Created by @kmartin62
 */
@Service
public class StudyProgramServiceImpl implements StudyProgramService {

    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramServiceImpl(StudyProgramRepository studyProgramRepository) {
        this.studyProgramRepository = studyProgramRepository;
    }

    @Override
    public List<StudyProgram> getAllStudyPrograms() {
        return (List<StudyProgram>) studyProgramRepository.findAll();
    }

    @Override
    public StudyProgram addNew(StudyProgram studyProgram) {
        return studyProgramRepository.save(studyProgram);
    }

    @Override
    public void delete(Long index) {
         studyProgramRepository.deleteById(index);
    }
}
