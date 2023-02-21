package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Course;
import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code/youtube", "Robotics");
        Instructor instructor = new Instructor("Shatha", "Qadomi", "shqadomi@luv2code.com");

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        instructor.setInstructorDetailProperty(instructorDetail);

        System.out.println("Saving instructor...");
        session.beginTransaction();
        session.save(instructor);

        session.getTransaction().commit();
        session.close();
    }
}
