package com.order.utils;

import com.order.model.Num;
import org.hibernate.Session;

public class EnterPoint {
    Object object = new Num(871155,"000000","1111");
    HibernateUtil hibernateUtil = new HibernateUtil();
    public void addToDataBase() {
        try (Session session = hibernateUtil.build();
             ){
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    public Object getFromDataBase(Num num, String id){
        try (Session session = hibernateUtil.build();
        ){
            session.beginTransaction();

        //    session.getTransaction().commit();
            return session.get("num", id);
        }
    }

}