package jpa.service;

import jpa.MainRunner;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class CourseService implements CourseDAO {


    @Override
    public List<Course> getAllCourses() {

        //create query
        EntityManager em = MainRunner.emf.createEntityManager();
        Query allCourses = em.createQuery("SELECT c from COURSE c");

        //return query as list
        return allCourses.getResultList();
    }
}
