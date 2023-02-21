package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEMCourseDemo {
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

            Course course = session.get(Course.class, 7);

            if (course != null) {
                System.out.println("**** Course retrieved: " + course.getTitle());

                System.out.println("**** Deleting the course...");

                session.delete(course);
            }

            session.getTransaction().commit();
        }
    }
}
