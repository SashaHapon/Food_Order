package com.order.utils;

import org.hibernate.Session;

public class EnterPoint {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public void createInDataBase(Object object) {
        try (Session session = hibernateUtil.build();
             ){
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    public Object readFromDataBase(Object object, Integer id){
        try (Session session = hibernateUtil.build();
        ){
            var newClass = object.getClass();
            session.beginTransaction();
            var n = session.get(newClass, id);
            System.out.println(n);
            session.getTransaction().commit();
            return n;
        }
    }
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