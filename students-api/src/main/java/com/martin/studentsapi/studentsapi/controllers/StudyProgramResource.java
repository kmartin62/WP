package com.martin.studentsapi.studentsapi.controllers;

import com.martin.studentsapi.studentsapi.models.StudyProgram;
import com.martin.studentsapi.studentsapi.services.StudyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by @kmartin62
 */
@CrossOrigin({"*"})
@RestController
@RequestMapping(value = "/study_programs", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudyProgramResource {

    private final StudyProgramService studyProgramService;

    @Autowired
    public StudyProgramResource(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @GetMapping
    public List<StudyProgram> getStudyPrograms(){
        return studyProgramService.getAllStudyPrograms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudyProgram(@RequestBody StudyProgram studyProgram){
        studyProgramService.createStudyProgram(studyProgram.getName());
    }

    @DeleteMapping("/{index}")
    public void deleteStudent(@PathVariable("index") Long index){
        studyProgramService.deleteStudyProgram(index);
    }


}
