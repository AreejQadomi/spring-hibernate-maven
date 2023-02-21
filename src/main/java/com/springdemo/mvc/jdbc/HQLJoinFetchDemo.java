package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLJoinFetchDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            int theId = 18;

            // Query to load instructor and courses all at once
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "WHERE i.id=:theId", Instructor.class);

            // set parameter on query
            query.setParameter("theId", theId);

            // execute query and get the instructor
            Instructor instructor = query.getSingleResult();

            if (instructor != null) {
                System.out.println("AreejDemoApp: Instructor: " + instructor);

                session.getTransaction().commit();
                session.close();

                System.out.println("AreejDemoApp: Done! The session is closed now.");

                System.out.println("AreejDemoApp: getting instructor courses after the session is closed.");
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
