package jpa.entitymodels;

import javax.persistence.*;

@Entity
public class Course {
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int cId;
    @Column (name = "name")
    private String cName;
    @Column (name = "instructor")
    private String cInstructorName;

    public Course() {
        cName = "null";
        cInstructorName = "null";
    }

    public Course(String cName, String cInstructorName) {
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    //getters and setters

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCInstructorName() {
        return cInstructorName;
    }

    public void setCInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}
