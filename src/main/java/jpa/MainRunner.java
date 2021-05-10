package jpa;

import jpa.entitymodels.*;
import jpa.service.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class MainRunner {
    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sms");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;
        boolean repeat = true;

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        while (repeat) {

            System.out.println("Are you a(n)\n1: Student\n2: Quit\nPlease, enter 1 or 2.");
            choice = input.nextLine();

            switch (choice.charAt(0)) {
                case '1':
                    //user selected to login
                    System.out.println("Enter Your Email:");
                    String email = input.nextLine();
                    System.out.println("Enter Your Password:");
                    String password = input.nextLine();

                    //check if credentials are correct
                    if (studentService.validateStudent(email, password)) {
                        //System.out.println("Successfully logged in!");
                        while (repeat) {
                            //display currently registered courses
                            System.out.println("My Classes:\n" +
                                                "#  " +
                                                "COURSE NAME                 " +
                                                "INSTRUCTOR NAME");
                            for (Course course : studentService.getStudentCourses(email)) {
                                System.out.printf("%-3d%-28s%-17s\n",
                                        course.getCId(),
                                        course.getCName(),
                                        course.getCInstructorName());
                            }


                            //prompt next choice
                            System.out.println("\n1: Register for Course\n2: Logout");
                            choice = input.nextLine();

                            switch(choice.charAt(0)){
                                case '1':
                                    //user selected to register for course
                                    System.out.println("All Courses\n" +
                                                        "ID " +
                                                        "COURSE NAME                 " +
                                                        "INSTRUCTOR NAME");
                                    //display all courses
                                   for (Course course : courseService.getAllCourses()) {
                                        System.out.printf("%-3d%-28s%-17s\n",
                                                course.getCId(),
                                                course.getCName(),
                                                course.getCInstructorName());
                                   }
                                   System.out.println("\nWhich course?");


                                   //get user input
                                   choice = input.nextLine();
                                   try {
                                       int courseId = Integer.parseInt(choice);

                                       //register to course
                                       studentService.registerStudentToCourse(email, courseId);

                                   } catch (NumberFormatException | NoResultException e) {
                                       //catch invalid numbers
                                       System.out.println("Please enter a valid course number.");
                                   }
                                    break;
                                case '2':
                                    //user selected to logout
                                    System.out.println("You have been signed out.");
                                    repeat = false;
                                    break;
                                default:
                                    //user entered an invalid input
                                    System.out.println("Invalid choice. Please enter 1 or 2.");

                            }
                        }
                    }
                    else System.out.println("Invalid username or password.");
                    break;
                case '2':
                    //user selected to exit
                    repeat = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    //user entered an invalid input
                    System.out.println("Invalid choice. Please enter 1 or 2");
            }
        }
    }
}
