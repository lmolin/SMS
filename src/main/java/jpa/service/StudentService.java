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

        List<Student> studentList = new ArrayList<Student>();

        //create query
        EntityManager em = MainRunner.emf.createEntityManager();
        Query allStudents = em.createQuery("SELECT s FROM student s");
        em.close();

        //convert List<Object> from query to List<Student>
        for (Object student : allStudents.getResultList()) {
            studentList.add((Student) student);
        }

        //return list from query
        return studentList;
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        //create entityManager
        EntityManager em = MainRunner.emf.createEntityManager();

        //Retrieve student
        Student student = em.find(Student.class, sEmail);

        em.close();

        return student;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        //retrieve student
        Student student = getStudentByEmail(sEmail);

        //check if password is correct
        if (student.getSPass().equals(sPassword))
            return true;
        else return false;
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        //start transaction
        EntityManager em = MainRunner.emf.createEntityManager();
        em.getTransaction().begin();

        //Find course by id
        Query query = em.createQuery("SELECT c FROM Course c WHERE Id = ?1");
        query.setParameter(1, cId);
        Course course = (Course) query.getSingleResult();

        //find student by email
        Student student = getStudentByEmail(sEmail);

        //check that student is not already in course
        List<Course> studentCourses = student.getSCourses();
        if (!studentCourses.contains(course)) {

            //update course list and set that as student's course list
            studentCourses.add(course);
            student.setSCourses(studentCourses);

            //commit changes
            em.merge(student);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        return getStudentByEmail(sEmail).getSCourses();
    }
}
