package com.pfunes.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by pfunes on 08/07/17.
 */
public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            session.save(new Student("Pablo", "Funes", "pabfun7@gmail.com" ));

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            factory.close();
        }

    }
}

