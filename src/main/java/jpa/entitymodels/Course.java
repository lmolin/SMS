package jpa.entitymodels;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
    private int cId;
    private String cName;
    private String cInstructorName;



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
