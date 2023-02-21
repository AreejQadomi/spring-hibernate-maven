package com.springdemo.mvc.jdbc;

import com.springdemo.mvc.models.Instructor;
import com.springdemo.mvc.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        //Session session = factory.getCurrentSession();

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            int theId = 17;
            InstructorDetail tempInstDetail = session.get(InstructorDetail.class, theId);

            if (tempInstDetail != null) {
                System.out.println("Getting instructor detail... " + tempInstDetail.getHobby());
                System.out.println("The associated instructor... " + tempInstDetail.getInstructorProperty().getFirstName());

                // remove deleted object from associations
                // Break the Bi-directional linking
                /*
                Instructor X----XX---->X Instructor detail
                           <-----------
                 */
                tempInstDetail.getInstructorProperty().setInstructorDetailProperty(null);

                session.delete(tempInstDetail);
                session.getTransaction().commit();
            } else {
                System.out.println("instructor detail not found with id: " + theId);
            }
        }

    }

}
