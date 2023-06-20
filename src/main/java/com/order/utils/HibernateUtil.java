package com.order.utils;

import com.order.model.Num;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;


    public static SessionFactory buildSessionFactory() throws HibernateException  {
            Configuration configuration = new Configuration();
      //  configuration.addAnnotatedClass(Account.class);
           configuration.configure();

        Num num = new Num(14,"2","43");

           try(SessionFactory sessionFactory = configuration.buildSessionFactory();
               Session session = sessionFactory.openSession();) {
               session.beginTransaction();

               session.save(num);

               session.getTransaction().commit();
               return sessionFactory;
           }
        }
}