package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        int theId = 14;
        Instructor temp = session.get(Instructor.class, theId);

        if (temp != null) {
            session.persist(temp);
            System.out.println("Found instructor: " + temp);

            System.out.println("Deleting instructor...");
            // should also delete the instructor details
            session.delete(temp);
            session.getTransaction().commit();
        }

        session.close();
    }
}
