package jpa.service;

import jpa.MainRunner;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDAO {


    @Override
    public List<Course> getAllCourses() {

        //create query
        EntityManager em = MainRunner.emf.createEntityManager();
        Query allCourses = em.createQuery("SELECT c from COURSE c");
        em.close();

        //convert List<Object> to List<Course>
        List<Course> courseList = new ArrayList<Course>();
        for(Object course: allCourses.getResultList()) {
            courseList.add((Course) course);
        }

        //return query as list
        return courseList;
    }
}
