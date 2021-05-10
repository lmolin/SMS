package jpa.service;

import javax.persistence.*;

import jpa.MainRunner;
import jpa.entitymodels.Student;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class ServiceTest {

    StudentService sService = new StudentService();

    @Test
    public void testIfConnectionExists() {
        EntityManager em = MainRunner.emf.createEntityManager();
        Assert.assertTrue(em.isOpen());
    }
    @Test
    public void testGetStudentByEmail() {
        Student s = sService.getStudentByEmail("aiannitti7@is.gd");

        Assert.assertTrue(s.getSName().equals("Alexandra Iannitti"));
        Assert.assertTrue(s.getSPass().equals("TWP4hf5j"));
    }

    @Test
    public void testValidateStudent() {
        Assert.assertTrue(sService.validateStudent("aiannitti7@is.gd", "TWP4hf5j"));
        Assert.assertFalse(sService.validateStudent("aiannitti7@is.gd", "IncorrectPassword"));
    }



}
