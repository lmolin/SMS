package jpa;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainRunner {
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sms");
}
