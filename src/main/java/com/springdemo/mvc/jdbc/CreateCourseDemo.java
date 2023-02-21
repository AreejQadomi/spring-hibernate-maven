package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
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
                // Add new courses

                Course course1 = new Course("Luv 2 Code!!"),
                       course2 = new Course("Spring and Hibernate");
                instructor.addCourse(course1);
                instructor.addCourse(course2);

                session.save(course1);
                session.save(course2);

                session.getTransaction().commit();


                // Retrieve instructor courses
//                List<Course> courses = instructor.getCourses();
//                for (Course course : courses) {
//                    System.out.println(course.getTitle());
//                }

                System.out.println("Done!");

            } else {
                System.out.println("instructor detail not found with id: " + theId);
            }
        }

    }
}
