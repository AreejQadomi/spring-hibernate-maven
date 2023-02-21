package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCoursesForAreejDemo {
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


            StudentTable student = session.get(StudentTable.class, 1);


            if (student != null) {
                System.out.println("**** Student retrieved: " + student.getEmail());

                List<Course> courses = student.getCoursesList();

                for (Course course : courses) {
                    System.out.println(course.getTitle());
                }
            }

            session.getTransaction().commit();
            System.out.println("Course saved - reviews saved - well done!");
        }
    }
}
