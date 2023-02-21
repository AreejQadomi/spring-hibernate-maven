package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            int theId = 18;

            Instructor instructor = session.get(Instructor.class, theId);

            if (instructor != null) {

                System.out.println("AreejDemoApp: Instructor: " + instructor);
                // Retrieve instructor courses
                List<Course> courses = instructor.getCourses();
                System.out.println("AreejDemoApp: Courses: ");
                for (Course course : courses) {
                    System.out.println(course.getTitle());
                }

                // Don't close the session before you retrieve all your lazy data
                session.getTransaction().commit();
                session.close();

                System.out.println("AreejDemoApp: Done!");

                System.out.println("AreejDemoApp: it's Ok to call the getter again after closing the session! because we called it before");
                List<Course> courses2 = instructor.getCourses();
                for (Course course : courses2) {
                    System.out.println(course.getTitle());
                }

            } else {
                System.out.println("instructor detail not found with id: " + theId);
            }
        }
    }
}
