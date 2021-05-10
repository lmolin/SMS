package jpa.service;

import jpa.MainRunner;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import javax.persistence.*;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentDAO {

    @Override
    public List<Student> getAllStudents() {

        //create query
        EntityManager em = MainRunner.emf.createEntityManager();
        Query allStudents = em.createQuery("SELECT s FROM student s");
        em.close();

        //convert List<Object> from query to List<Student>
        List<Student> studentList = new ArrayList<Student>();
        for(Object student: allStudents.getResultList()) {
            studentList.add((Student) student);
        }

        //return list from query
        return studentList;
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        EntityManager em = MainRunner.emf.createEntityManager();
        Student student = em.find(Student.class, sEmail);
        em.close();
        return student;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        Student student = getStudentByEmail(sEmail);
        if (student.getSPass().equals(sPassword))
            return true;
        else return false;
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {

    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        return null;
    }
}
