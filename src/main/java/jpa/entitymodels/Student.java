package jpa.entitymodels;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column (name = "email")
    private String sEmail;
    @Column (name = "name")
    private String sName;
    @Column (name = "password")
    private String sPass;
    private List<Course> sCourses;

    public Student() {
        sEmail = "null";
        sName = "null";
        sPass = "null";

    }

    //getters and setters

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }
}
