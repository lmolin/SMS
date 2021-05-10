package jpa.service;

import javax.persistence.*;
import jpa.MainRunner;
import jpa.entitymodels.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;


public class ServiceTest {

    StudentService sService = new StudentService();

    @Test
    public void testIfConnectionExists() {
        //create connection
        EntityManager em = MainRunner.emf.createEntityManager();
        //check that connection is open
        Assert.assertTrue(em.isOpen());
    }

    @Test
    public void testGetStudentByEmail() {
        Student s = sService.getStudentByEmail("aiannitti7@is.gd");

        //check for correct name
        Assert.assertTrue(s.getSName().equals("Alexandra Iannitti"));
        //check for correct email
        Assert.assertTrue(s.getSPass().equals("TWP4hf5j"));
    }

    @Test
    public void testValidateStudent() {
        //check for correct password
        Assert.assertTrue(sService.validateStudent("aiannitti7@is.gd", "TWP4hf5j"));
        //check for incorrect password
        Assert.assertFalse(sService.validateStudent("aiannitti7@is.gd", "IncorrectPassword"));
    }

    @Test
    //this test assumes getStudentCourses method works. use testGetStudentCourses
    public void testRegisterStudentToCourse() {
        //execute method to test
        sService.registerStudentToCourse("aiannitti7@is.gd", 1);

        //check that student is registered to course
        List<Course> courseList = sService.getStudentCourses("aiannitti7@is.gd");
        Assert.assertTrue(courseList.get(0).getCId() == 1);
    }
}
