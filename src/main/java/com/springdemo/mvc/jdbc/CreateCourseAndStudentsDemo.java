package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(StudentTable.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            // Create new course
            Course newCourse = new Course("Electro magnetics 2");

            // add some reviews
            newCourse.addReview(new Review("Baaaad!! so baaad! I hate it!"));
            newCourse.addReview(new Review("1 star"));
            newCourse.addReview(new Review("0 star"));
            newCourse.addReview(new Review("0.5 star"));

            // save the course -  should save all reviews by cascading
            session.save(newCourse);

            // add some students to the course
            StudentTable student1 = new StudentTable("Areej", "Qadomi", "aqadomi@yahoo.com");
            StudentTable student2 = new StudentTable("Ahmad", "Qadomi", "aqadomi@yahoo.com");
            StudentTable student3 = new StudentTable("Omar", "Qadomi", "oqadomi@yahoo.com");
            StudentTable student4 = new StudentTable("Shatha", "Qadomi", "shqadomi@yahoo.com");

            newCourse.addStudent(student1);
            newCourse.addStudent(student2);
            newCourse.addStudent(student3);
            newCourse.addStudent(student4);

            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);


            session.getTransaction().commit();
            System.out.println("Course saved - reviews saved - well done!");
        }
    }
}
