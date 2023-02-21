package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDemo {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            int theId = 134;
            InstructorDetail tempInstDetail = session.get(InstructorDetail.class, theId);

            if (tempInstDetail != null) {
                System.out.println("Getting instructor detail... " + tempInstDetail.getHobby());
                System.out.println("The associated instructor... " + tempInstDetail.getInstructorProperty().getFirstName());
            } else {
                System.out.println("instructor detail not found with id: " + theId);
            }
        }
    }
}