package com.xmlbased_hibernate.app;

import com.xmlbased_hibernate.entity.Student;
import com.xmlbased_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId(103);
        s.setName("keysha");

        Session session =null;
        Transaction tx=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(s);
            tx.commit();
        }catch (Exception e){
            e.getMessage();
            tx.rollback();
        }
        session.close();

    }
}
