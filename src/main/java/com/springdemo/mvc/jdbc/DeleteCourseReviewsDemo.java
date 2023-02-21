package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import com.springdemo.mvc.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteCourseReviewsDemo {
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

            // get the course
            int courseId = 5;
            Course myCourse = session.get(Course.class, courseId);

            if (myCourse != null) {
                System.out.println("here found the course: " + myCourse.getTitle());

                // get the course reviews
                List<Review> reviews = myCourse.getReviews();
                System.out.println("*** reviews listed: ");
                for (Review review : reviews) {
                    System.out.println(review.getComment());
                }

                // Delete the course
                session.delete(myCourse);

            }

            session.getTransaction().commit();
        }
    }
}
