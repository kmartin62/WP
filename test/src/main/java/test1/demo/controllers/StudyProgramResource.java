package test1.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test1.demo.model.StudyProgram;
import test1.demo.service.StudyProgramService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping(value = "/study_program", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping("/all")
    public List<StudyProgram> getAllStudyPrograms(){
        return getStudyPrograms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody StudyProgram studyProgram, HttpServletResponse response){
        StudyProgram studyProgram1 = studyProgramService.addNew(studyProgram);
        response.setHeader("Location", "/study_program/" + studyProgram1.getId());
    }

    @DeleteMapping("/{index}")
    public @ResponseBody void delete(@PathVariable Long index){
        studyProgramService.delete(index);
    }
}
