package com.pfunes.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by pfunes on 08/07/17.
 */
public class SelectStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            System.out.println("Student 1 : " + session.get(Student.class, 1));

            List<Student> students = session.createQuery("from Student").getResultList();

            for (Student s : students)
                System.out.println(s);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            factory.close();
        }

    }
}
