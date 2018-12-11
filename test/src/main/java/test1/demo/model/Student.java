package test1.demo.model;

import javax.persistence.*;

/**
 * Created by @kmartin62
 */
@Entity
public class Student {

    @Id
    private String index;
    private String name;
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinTable(name = "study_program_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "study_program_id"))
    private StudyProgram studyPrograms;

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

    public StudyProgram getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(StudyProgram studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
}
