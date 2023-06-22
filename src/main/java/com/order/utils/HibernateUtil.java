package com.order.utils;

import com.order.model.Num;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    Object object = new Num(2000,"df","ere");
    public Session buildSessionFactory() throws HibernateException  {
        Configuration configuration = new Configuration();
        configuration.configure();


        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            return session;
           }
        }

    public Session build(){
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
    public Object addObject(Object object){
        var session = buildSessionFactory();
        session.beginTransaction();
        session.save(this.object);
        session.getTransaction().commit();
        return object;
    }


}