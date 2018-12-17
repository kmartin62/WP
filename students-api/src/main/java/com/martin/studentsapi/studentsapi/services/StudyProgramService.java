package com.martin.studentsapi.studentsapi.services;

import com.martin.studentsapi.studentsapi.models.StudyProgram;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface StudyProgramService {

    List<StudyProgram> getAllStudyPrograms();

    StudyProgram createStudyProgram(String name);

    StudyProgram deleteStudyProgram(Long index);

}
