package com.order.utils;

import com.order.model.Num;
import org.hibernate.Session;

public class EnterPoint {
    Object object = new Num(871155,"000000","1111");
    HibernateUtil hibernateUtil = new HibernateUtil();
    public void createInDataBase() {
        try (Session session = hibernateUtil.build();
             ){
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    public Object readFromDataBase(Integer id){
        try (Session session = hibernateUtil.build();
        ){
            Num n = new Num();
            session.beginTransaction();

            n = (Num) session.get("com.order.model.Num", id);
            System.out.println(n);
            session.getTransaction().commit();
            return n;
        }
    }
//session.get(Num.class, id)
    public Object updateInDataBase(Object object){
        try(Session session = hibernateUtil.build()){
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
    }
        return object;
    }

    public void deleteInDataBase(Object object){
        try(Session session = hibernateUtil.build()){
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        }
    }

}