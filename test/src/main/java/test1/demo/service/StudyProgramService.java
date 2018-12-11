package test1.demo.service;

import test1.demo.model.StudyProgram;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface StudyProgramService {

    List<StudyProgram> getAllStudyPrograms();

    StudyProgram addNew(StudyProgram studyProgram);

    void delete(Long index);

}
