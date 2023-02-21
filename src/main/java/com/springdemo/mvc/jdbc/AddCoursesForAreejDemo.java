package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForAreejDemo {
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
            Course newCourse = new Course("Digital Objects");
            Course newCourse2 = new Course("Computer Organization");

            StudentTable student = session.get(StudentTable.class, 1);

            if (student != null) {
                student.addCourse(newCourse);
                student.addCourse(newCourse2);

                session.save(student);
            }

            // add some reviews
            newCourse.addReview(new Review("Love this"));
            newCourse.addReview(new Review("5 star"));
            newCourse2.addReview(new Review("Great"));
            newCourse2.addReview(new Review("Awesome"));

            // save the course -  should save all reviews by cascading
            session.save(newCourse);
            session.save(newCourse2);


            session.getTransaction().commit();
            System.out.println("Course saved - reviews saved - well done!");
        }
    }
}
