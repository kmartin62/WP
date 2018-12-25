package com.martin.studentsapi.studentsapi.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by @kmartin62
 */
public class StudentDto {

    @JsonProperty("index")
    private String index;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("studyProgram")
    private String studyProgram;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }
}
