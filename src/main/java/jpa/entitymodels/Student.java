package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "student")
public class Student {
    @Id
    @Column (name = "email")
    private String sEmail;
    @Column (name = "name")
    private String sName;
    @Column (name = "password")
    private String sPass;

    public Student() {
    }

    //getters and setters

    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSPass() {
        return sPass;
    }

    public void setSPass(String sPass) {
        this.sPass = sPass;
    }
}
