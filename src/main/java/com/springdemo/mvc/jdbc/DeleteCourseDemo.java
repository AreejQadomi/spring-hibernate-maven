package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import com.springdemo.mvc.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            int theId = 18;

            Instructor instructor = session.get(Instructor.class, theId);

            if (instructor != null) {
                // Delete instructor courses
                List<Course> courses = instructor.getCourses();

                for (Course course : courses) {
                   // session.delete(course);
                }

                // Delete course by ID

                Course course = session.get(Course.class, 4);
                session.delete(course);

                session.getTransaction().commit();
                System.out.println("Done!");

            } else {
                System.out.println("instructor detail not found with id: " + theId);
            }
        }

    }
}
