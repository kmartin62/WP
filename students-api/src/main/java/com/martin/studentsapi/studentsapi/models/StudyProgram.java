package com.martin.studentsapi.studentsapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by @kmartin62
 */
@Entity
public class StudyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
