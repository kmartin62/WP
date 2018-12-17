package com.martin.studentsapi.studentsapi.services.impl;

import com.martin.studentsapi.studentsapi.models.StudyProgram;
import com.martin.studentsapi.studentsapi.repositories.StudyProgramRepository;
import com.martin.studentsapi.studentsapi.services.StudyProgramService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public StudyProgram createStudyProgram(String name) {

        StudyProgram studyProgram = new StudyProgram();
        studyProgram.setName(name);

        return studyProgramRepository.save(studyProgram);
    }

    @Override
    public StudyProgram deleteStudyProgram(Long index) {

        Optional<StudyProgram> studyProgram = studyProgramRepository.findById(index);

        studyProgramRepository.delete(studyProgram.get());

        return studyProgram.get();
    }
}
