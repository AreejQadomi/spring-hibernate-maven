package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import com.springdemo.mvc.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseReviewsDemo {
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

            // Create new course
            Course newCourse = new Course("Electro magnetics");

            // add some reviews
            newCourse.addReview(new Review("Baaaad!! so baaad! I hate it!"));
            newCourse.addReview(new Review("1 star"));
            newCourse.addReview(new Review("0 star"));
            newCourse.addReview(new Review("0.5 star"));

            // save the course -  should save all reviews by cascading
            session.save(newCourse);

            session.getTransaction().commit();
            System.out.println("Course saved - reviews saved - well done!");
        }
    }
}
